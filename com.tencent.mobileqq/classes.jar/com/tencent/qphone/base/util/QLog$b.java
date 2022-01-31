package com.tencent.qphone.base.util;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class QLog$b
  extends RecyclablePool.Recyclable
{
  public long a;
  public int b;
  public int c;
  public String d;
  public int e;
  public String f;
  public Throwable g;
  public byte[] h;
  
  public void recycle()
  {
    super.recycle();
    this.a = 0L;
    this.b = 0;
    this.c = 0;
    this.d = "";
    this.f = "";
    this.e = 0;
    this.h = null;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.QLog.b
 * JD-Core Version:    0.7.0.1
 */