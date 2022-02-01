package com.tencent.mobileqq.onlinestatus.config;

import android.support.annotation.NonNull;

public class Sensor
{
  public int a;
  public String b;
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
  public int y;
  
  public Sensor() {}
  
  public Sensor(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sensor [id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", min=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", max=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", sampleCount=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mainSensor=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", secondarySensor=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("， internalUpdateStatus=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", sessionEnterAccuracy=");
    localStringBuilder.append(this.o);
    localStringBuilder.append("， slowModeCount=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("， fastModeCount=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("， internalSlowMode=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("， internalFastMode=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("， internalExitStep=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("， internalExitStill=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", distAccuracy=");
    localStringBuilder.append(this.p);
    localStringBuilder.append("， distThreadHold=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("， distStepTH=");
    localStringBuilder.append(this.r);
    localStringBuilder.append("， distEnable=");
    localStringBuilder.append(this.s);
    localStringBuilder.append("， distReqTime=");
    localStringBuilder.append(this.t);
    localStringBuilder.append("， distAccelerEnable=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", distSpeedReqTime=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", distSpeedThreadHold=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", distMovingMax=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", distNotMovingMin=");
    localStringBuilder.append(this.y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.Sensor
 * JD-Core Version:    0.7.0.1
 */