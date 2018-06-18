package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class Super_GUI
{
    private JPanel super_java_GUI;
    private JPanel fensterleiste;
    private JButton gelberButton;
    private JButton gruenerButton;
    private JButton roterButton;
    private JPanel menuleiste;
    private JLabel windowIcon;
    private JRadioButton appleButton;
    private JPanel seitenLeiste;
    private JLabel appleIcon;
    private JRadioButton windowButton;
    private JRadioButton otherButton;
    private JButton infoButton;
    private JButton gruen2Button;
    private JButton gelb2Button;
    private JButton rot2Button;
    private JButton buttonB;

    private int xx = 0;
    private int yy = 0;
    private String select = "apple";
    private boolean maximierer = false;
    private static JFrame frame = new JFrame("HIER können Sie Ihre eigene Werbung einfügen");


    //Startet das Fenster und macht es sichtbar
    public static void main(String[] args)
    {
        frame.setContentPane(new Super_GUI().super_java_GUI);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Aktivieren wenn die GUI ihre Größe nicht verändern soll
        //frame.setResizable(false);

        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    //Selektiert das zuletzt verwendete Design
    private void selektor ()
    {
        if (select.equals("apple")) appleButton.setSelected(true);
        else if (select.equals("window")) windowButton.setSelected(true);
        else if (select.equals("other")) otherButton.setSelected(true);
    }

    private void maximizer ()
    {
        if (!maximierer)
        {
            maximierer = true;
            gelb2Button.setIcon(new ImageIcon(Class.class.getResource("/img/square_maximized.png")));
            gelb2Button.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/square_maximized_rollover.png")));
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        else
        {
            gelb2Button.setIcon(new ImageIcon(Class.class.getResource("/img/square.png")));
            gelb2Button.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/square_rollover.png")));
            frame.setExtendedState(JFrame.NORMAL);
            frame.pack();
            maximierer = false;
        }
    }


    private Super_GUI() {

        //----Die weiteren Buttons sind nur für die Navigationstasten und für die Funktion des Programms nicht relevant -------------
        //Minimiert das Programmfenster
        gruenerButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));

        //Maximiert das Programmfenster
        gelberButton.addActionListener(e ->
        {
            maximizer();
            //Aktivieren wenn keine Maximierung gewünscht ist
            //JOptionPane.showMessageDialog(frame, "Die Maximierung wurde deaktiviert!")
        });

        //Beendet das Programm
        roterButton.addActionListener(e -> System.exit(0));

        //Die Buttons machen das gleiche wie die oberen, sind aber im Apple Look nicht sichtbar
        gruen2Button.addActionListener(e -> frame.setState(Frame.ICONIFIED));

        gelb2Button.addActionListener(e ->
        {
            maximizer();
            //Aktivieren wenn keine Maximierung gewünscht ist
            //JOptionPane.showMessageDialog(frame, "Die Maximierung wurde deaktiviert!")
        });

        rot2Button.addActionListener(e -> System.exit(0));

        fensterleiste.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                xx = e.getX();
                yy = e.getY();
            }
        });

        fensterleiste.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                frame.setLocation(frame.getLocation().x+e.getX()-xx, frame.getLocation().y+e.getY()-yy);
            }
        });

        ButtonGroup groupie = new ButtonGroup();
        groupie.add(appleButton);
        groupie.add(windowButton);
        groupie.add(otherButton);

        //Ändert das Design in Apple Optik
        appleButton.addActionListener(e ->
        {
            frame.dispose();
            frame.setUndecorated(true);

            fensterleiste.setBackground(Color.decode("#6380C2"));
            gruenerButton.setIcon(new ImageIcon(Class.class.getResource("/img/gruen.png")));
            gruenerButton.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/gruen_mouseover.png")));
            gruenerButton.setMargin(new Insets(2, 5, 2, 5));
            gruenerButton.setVisible(true);
            gruen2Button.setVisible(false);

            gelberButton.setIcon(new ImageIcon(Class.class.getResource("/img/gelb.png")));
            gelberButton.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/gelb_mouseover.png")));
            gelberButton.setMargin(new Insets(2, 5, 2, 5));
            gelberButton.setVisible(true);
            gelb2Button.setVisible(false);

            roterButton.setIcon(new ImageIcon(Class.class.getResource("/img/rot.png")));
            roterButton.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/rot_mouseover.png")));
            roterButton.setMargin(new Insets(2, 5, 2, 5));
            roterButton.setVisible(true);
            rot2Button.setVisible(false);

            fensterleiste.setVisible(true);
            frame.pack();
            frame.setVisible(true);
            select = "apple";
        });

        //Ändert das Design in Windows Optik
        windowButton.addActionListener(e ->
        {
            frame.dispose();
            frame.setUndecorated(true);

            fensterleiste.setBackground(Color.decode("#c2d901"));
            gruen2Button.setIcon(new ImageIcon(Class.class.getResource("/img/line.png")));
            gruen2Button.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/line_rollover.png")));
            gruen2Button.setMargin(new Insets(0, 0, 0, 0));
            gruenerButton.setVisible(false);
            gruen2Button.setVisible(true);

            gelb2Button.setMargin(new Insets(0, 0, 0, 0));
            gelberButton.setVisible(false);
            if (maximierer)
            {
                gelb2Button.setIcon(new ImageIcon(Class.class.getResource("/img/square_maximized.png")));
                gelb2Button.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/square_maximized_rollover.png")));
            }
            else
            {
                gelb2Button.setIcon(new ImageIcon(Class.class.getResource("/img/square.png")));
                gelb2Button.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/square_rollover.png")));
            }
            gelb2Button.setVisible(true);

            rot2Button.setIcon(new ImageIcon(Class.class.getResource("/img/cross.png")));
            rot2Button.setRolloverIcon(new ImageIcon(Class.class.getResource("/img/cross_rollover.png")));
            rot2Button.setMargin(new Insets(0, 0, 0, 0));
            roterButton.setVisible(false);
            rot2Button.setVisible(true);

            fensterleiste.setVisible(true);
            frame.pack();
            frame.setVisible(true);
            select = "window";
        });

        //Ändert das Design in die Standardoptik des Betriebssystems
        otherButton.addActionListener(e ->
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (frame, " Wollen Sie sich wirklich das " +
                    "Standard Design des Systems antun? \n Besonders einige Linux Distributionen wie Ubuntu oder Elementary \n" +
                    " haben ein furchtbar grottiges Design, welches keinen Wert auf eine \n" +
                    " einfache Bedienung legt, obwohl es das bei anderen Betriebssystemen \n schon vor 23 Jahren gegeben hat.","Achtung!",dialogButton);
            if ((dialogResult == JOptionPane.YES_OPTION))
            {
                fensterleiste.setVisible(false);
                frame.dispose();
                frame.setUndecorated(false);
                frame.pack();
                frame.setVisible(true);
                select = "other";
            } else selektor();
        });

        //Gibt eine kleine Info über die Funktionen der Buttons darüber
        infoButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, " Über diese Seitenleiste" +
                " kann die Fensterdekoration eingestellt\n werden, wählen Sie den Look aus, der Ihnen am Besten gefällt!"));
    }
}
