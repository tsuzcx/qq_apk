package com.tencent.qqperf;

import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

class UnifiedMonitor$FamilyConfig
{
  int a = 100;
  int b = 10;
  float c = 0.001F;
  float d = 0.1F;
  int e = 0;
  int f = 500;
  int g = 5;
  int h = 300;
  int i = 0;
  int j = 0;
  long k = 0L;
  boolean l = false;
  volatile boolean m = false;
  volatile String n = null;
  volatile long o = 0L;
  boolean p = false;
  volatile UnifiedMonitor.StackGetterJob q;
  AbstractUnifiedMonitor.ThreadMonitorCallback r;
  int s = 0;
  boolean t = false;
  
  UnifiedMonitor$FamilyConfig() {}
  
  UnifiedMonitor$FamilyConfig(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    this.c = paramFloat1;
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramFloat2;
    this.e = paramInt3;
    this.s = paramInt4;
    this.t = paramBoolean;
  }
  
  public void a(int paramInt)
  {
    if ((UnifiedMonitor.g()) && (paramInt != 9) && (this.c > 0.0F))
    {
      this.c = 1.0F;
      this.d = 1.0F;
      this.b = 2147483647;
    }
    boolean bool;
    if (Math.random() <= this.c) {
      bool = true;
    } else {
      bool = false;
    }
    this.l = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor.FamilyConfig
 * JD-Core Version:    0.7.0.1
 */