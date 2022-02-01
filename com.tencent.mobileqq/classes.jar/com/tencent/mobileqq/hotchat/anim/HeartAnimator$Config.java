package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class HeartAnimator$Config
{
  public static float b = 1.0F;
  public float a;
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public float c;
  public int c;
  public int d = 10;
  public int e = 8;
  public int f = 150;
  public int g = 300;
  public int h = 32;
  public int i = 27;
  public int j = 3000;
  public int k;
  public int l;
  
  private HeartAnimator$Config()
  {
    this.jdField_a_of_type_Int = 250;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 20;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public HeartAnimator$Config(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_Int = 250;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 20;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramHeartLayout.getContext().getResources().getDisplayMetrics().density;
    float f1 = paramHeartLayout.getWidth();
    float f2 = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_Int = ((int)((f1 - f2 * 32.0F) / 2.0F));
    this.jdField_b_of_type_Int = ((int)(f2 * 27.0F));
    this.h = ((int)(32.0F * f2));
    this.i = ((int)(27.0F * f2));
    this.jdField_c_of_type_Int = ((int)(20.0F * f2));
    this.d = ((int)(10.0F * f2));
    this.f = ((int)(150.0F * f2));
    this.g = ((int)(f2 * 300.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config
 * JD-Core Version:    0.7.0.1
 */