package com.tencent.qgplayer.rtmpsdk.a;

public class b
{
  public int a;
  public int b;
  private volatile int c;
  private volatile int d;
  
  public void a()
  {
    this.c = 0;
  }
  
  public void b()
  {
    this.d = 0;
  }
  
  public b c()
  {
    this.c += 1;
    return this;
  }
  
  public b d()
  {
    this.d += 1;
    return this;
  }
  
  public boolean e()
  {
    return this.c > 40;
  }
  
  public boolean f()
  {
    return this.d > 60;
  }
  
  public boolean g()
  {
    return this.c > 60;
  }
  
  public boolean h()
  {
    return this.d > 80;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a.b
 * JD-Core Version:    0.7.0.1
 */