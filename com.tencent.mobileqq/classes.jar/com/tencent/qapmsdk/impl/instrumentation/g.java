package com.tencent.qapmsdk.impl.instrumentation;

import android.os.Looper;

public class g
  extends j
{
  public int a;
  public int b;
  public int c;
  public boolean d = false;
  
  public g()
  {
    this.c = 0;
    this.b = 1;
    this.a = 0;
  }
  
  public g(String paramString, int paramInt)
  {
    l.c localc;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      localc = l.c.a;
    } else {
      localc = l.c.b;
    }
    this.b = localc.a();
    this.g = paramString;
    this.a = paramInt;
    this.e = System.currentTimeMillis();
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    l.c localc;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      localc = l.c.a;
    } else {
      localc = l.c.b;
    }
    this.b = localc.a();
    this.g = paramString1;
    this.h = paramString2;
    this.a = paramInt;
    this.e = System.currentTimeMillis();
  }
  
  public g(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    l.c localc;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      localc = l.c.a;
    } else {
      localc = l.c.b;
    }
    this.b = localc.a();
    this.g = paramString1;
    this.h = paramString2;
    this.a = paramInt;
    this.e = paramLong1;
    this.f = paramLong2;
  }
  
  public void a()
  {
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.g
 * JD-Core Version:    0.7.0.1
 */