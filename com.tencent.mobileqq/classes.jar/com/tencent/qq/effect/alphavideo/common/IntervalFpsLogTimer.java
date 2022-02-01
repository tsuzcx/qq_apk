package com.tencent.qq.effect.alphavideo.common;

public class IntervalFpsLogTimer
{
  private int mFps = 0;
  protected long mInterval;
  private long mLastTime = 0L;
  
  public IntervalFpsLogTimer(int paramInt)
  {
    long l = paramInt;
    this.mInterval = l;
    this.mLastTime = (System.currentTimeMillis() - l - 1L);
  }
  
  public int getFps()
  {
    long l = this.mInterval;
    int i;
    if (l != 0L) {
      i = this.mFps * 1000 / (int)l;
    } else {
      i = this.mFps;
    }
    this.mFps = 0;
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.common.IntervalFpsLogTimer
 * JD-Core Version:    0.7.0.1
 */