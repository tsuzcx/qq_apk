package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class HeartAnimator$Config
{
  public static float l = 1.0F;
  public float a;
  public int b = 250;
  public int c = 0;
  public int d = 20;
  public int e = 10;
  public int f = 8;
  public int g = 150;
  public int h = 300;
  public int i = 32;
  public int j = 27;
  public int k = 3000;
  public boolean m = false;
  public int n;
  public int o;
  public float p = 1.0F;
  public boolean q = true;
  
  private HeartAnimator$Config() {}
  
  public HeartAnimator$Config(HeartLayout paramHeartLayout)
  {
    this.a = paramHeartLayout.getContext().getResources().getDisplayMetrics().density;
    float f1 = paramHeartLayout.getWidth();
    float f2 = this.a;
    this.b = ((int)((f1 - f2 * 32.0F) / 2.0F));
    this.c = ((int)(f2 * 27.0F));
    this.i = ((int)(32.0F * f2));
    this.j = ((int)(27.0F * f2));
    this.d = ((int)(20.0F * f2));
    this.e = ((int)(10.0F * f2));
    this.g = ((int)(150.0F * f2));
    this.h = ((int)(f2 * 300.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config
 * JD-Core Version:    0.7.0.1
 */