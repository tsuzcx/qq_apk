package org.jbox2d.common;

public class Timer
{
  private long resetNanos;
  
  public Timer()
  {
    reset();
  }
  
  public float getMilliseconds()
  {
    return (float)((System.nanoTime() - this.resetNanos) / 1000L) * 1.0F / 1000.0F;
  }
  
  public void reset()
  {
    this.resetNanos = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.common.Timer
 * JD-Core Version:    0.7.0.1
 */