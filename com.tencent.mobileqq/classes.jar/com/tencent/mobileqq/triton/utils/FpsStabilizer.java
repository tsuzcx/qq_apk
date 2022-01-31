package com.tencent.mobileqq.triton.utils;

public class FpsStabilizer
{
  private volatile long mAccumulateStartTime = -1000L;
  private int mAccumulatedFrames = 0;
  private volatile double mFpsInterval = 0.0D;
  
  public void setTargetFps(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    for (this.mFpsInterval = 0.0D;; this.mFpsInterval = (1000.0F / (1.1F * paramFloat)))
    {
      this.mAccumulateStartTime = 0L;
      return;
    }
  }
  
  public boolean shouldDoFrame(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.mFpsInterval == 0.0D) {
      return bool2;
    }
    long l = paramLong - this.mAccumulateStartTime;
    if (l / this.mFpsInterval > this.mAccumulatedFrames) {
      this.mAccumulatedFrames += 1;
    }
    for (;;)
    {
      bool2 = bool1;
      if (l <= 1000L) {
        break;
      }
      this.mAccumulateStartTime = paramLong;
      this.mAccumulatedFrames = 0;
      return bool1;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.FpsStabilizer
 * JD-Core Version:    0.7.0.1
 */