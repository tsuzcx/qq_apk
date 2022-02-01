package com.tencent.mobileqq.microapp.appbrand.b;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class c$a
  extends RecyclablePool.Recyclable
{
  public long a;
  public int b;
  public int c;
  public String d;
  public String e;
  public Throwable f;
  public String g;
  
  public void recycle()
  {
    super.recycle();
    this.a = 0L;
    this.b = 0;
    this.c = 0;
    this.d = "";
    this.e = "";
    this.f = null;
    this.g = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.c.a
 * JD-Core Version:    0.7.0.1
 */