package com.tencent.mobileqq.magicface.magicfaceaction;

import adqo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Timer;
import java.util.TimerTask;

public class ActionGlobalData
{
  public float a;
  public int a;
  public ActionGlobalData.ActionCountdownOver a;
  public MagicfacebackText a;
  public String a;
  TimerTask a;
  public boolean a;
  public int b;
  public String b = "non-ver";
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e = true;
  public int f = 50;
  public String f;
  public boolean f;
  public int g = 30;
  public String g;
  public boolean g;
  public int h = 0;
  public String h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public ActionGlobalData()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "send";
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilTimerTask = new adqo(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = this.jdField_c_of_type_Int;
    ThreadManager.getTimer().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 100L);
  }
  
  public void a(ActionGlobalData.ActionCountdownOver paramActionCountdownOver)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData$ActionCountdownOver = paramActionCountdownOver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData
 * JD-Core Version:    0.7.0.1
 */