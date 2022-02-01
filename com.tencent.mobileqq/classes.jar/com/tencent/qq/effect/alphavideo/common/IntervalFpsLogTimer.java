package com.tencent.qq.effect.alphavideo.common;

public class IntervalFpsLogTimer
{
  private int mFps = 0;
  protected long mInterval;
  private long mLastTime = 0L;
  
  public IntervalFpsLogTimer(int paramInt)
  {
    this.mInterval = paramInt;
    this.mLastTime = (System.currentTimeMillis() - paramInt - 1L);
  }
  
  public int getFps()
  {
    if (this.mInterval != 0L) {}
    for (int i = this.mFps * 1000 / (int)this.mInterval;; i = this.mFps)
    {
      this.mFps = 0;
      return i;
    }
  }
  
  public boolean isTimeToWriteLog()
  {
    this.mFps += 1;
    if (this.mLastTime + this.mInterval < System.currentTimeMillis())
    {
      this.mLastTime = System.currentTimeMillis();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.common.IntervalFpsLogTimer
 * JD-Core Version:    0.7.0.1
 */