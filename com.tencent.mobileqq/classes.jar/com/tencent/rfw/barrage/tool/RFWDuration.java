package com.tencent.rfw.barrage.tool;

public class RFWDuration
{
  private long a;
  private long b;
  
  public RFWDuration(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    this.b = (((float)this.b * paramFloat));
  }
  
  public RFWDuration b()
  {
    return new RFWDuration(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWDuration
 * JD-Core Version:    0.7.0.1
 */