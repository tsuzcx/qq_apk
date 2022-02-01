package com.tencent.rfw.barrage.tool;

import android.os.SystemClock;

public class RFWBarrageDrawTimer
{
  private long a;
  private long b;
  private long c;
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
  }
  
  public long b()
  {
    return this.a;
  }
  
  public long c()
  {
    this.b = (SystemClock.uptimeMillis() - this.c);
    this.a += this.b;
    d();
    return this.b;
  }
  
  public void d()
  {
    this.c = SystemClock.uptimeMillis();
  }
  
  public long e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWBarrageDrawTimer
 * JD-Core Version:    0.7.0.1
 */