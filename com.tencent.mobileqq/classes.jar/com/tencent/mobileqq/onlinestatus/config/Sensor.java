package com.tencent.mobileqq.onlinestatus.config;

import android.support.annotation.NonNull;

public class Sensor
{
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  public int x;
  
  public Sensor() {}
  
  public Sensor(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sensor [id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", min=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", max=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sampleCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mainSensor=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", secondarySensor=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("， internalUpdateStatus=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", sessionEnterAccuracy=");
    localStringBuilder.append(this.n);
    localStringBuilder.append("， slowModeCount=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("， fastModeCount=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("， internalSlowMode=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("， internalFastMode=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("， internalExitStep=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("， internalExitStill=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", distAccuracy=");
    localStringBuilder.append(this.o);
    localStringBuilder.append("， distThreadHold=");
    localStringBuilder.append(this.p);
    localStringBuilder.append("， distStepTH=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("， distEnable=");
    localStringBuilder.append(this.r);
    localStringBuilder.append("， distReqTime=");
    localStringBuilder.append(this.s);
    localStringBuilder.append("， distAccelerEnable=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", distSpeedReqTime=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", distSpeedThreadHold=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", distMovingMax=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", distNotMovingMin=");
    localStringBuilder.append(this.x);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.Sensor
 * JD-Core Version:    0.7.0.1
 */