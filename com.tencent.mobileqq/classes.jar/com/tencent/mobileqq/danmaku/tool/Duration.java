package com.tencent.mobileqq.danmaku.tool;

public class Duration
{
  private long a;
  private long b;
  
  public Duration(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public Duration a()
  {
    return new Duration(this.b);
  }
  
  public void a(float paramFloat)
  {
    this.b = (((float)this.b * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.Duration
 * JD-Core Version:    0.7.0.1
 */