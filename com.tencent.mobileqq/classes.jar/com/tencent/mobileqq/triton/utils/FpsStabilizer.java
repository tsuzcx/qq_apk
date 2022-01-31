package com.tencent.mobileqq.triton.utils;

public class FpsStabilizer
{
  private static final long ONE_SECOND_IN_NANOS = 1000000000L;
  private volatile long mAccumulateStartTimeNanos = -1000L;
  private int mAccumulatedFrames = 0;
  private volatile double mFpsIntervalNanos = 0.0D;
  
  public void setTargetFps(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    for (this.mFpsIntervalNanos = 0.0D;; this.mFpsIntervalNanos = (1000000000.0D / (paramFloat * 1.0D)))
    {
      this.mAccumulateStartTimeNanos = 0L;
      return;
    }
  }
  
  public boolean shouldDoFrame(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.mFpsIntervalNanos == 0.0D) {
      return bool2;
    }
    long l = paramLong - this.mAccumulateStartTimeNanos;
    if (l / this.mFpsIntervalNanos > this.mAccumulatedFrames) {
      this.mAccumulatedFrames += 1;
    }
    for (;;)
    {
      bool2 = bool1;
      if (l <= 1000000000L) {
        break;
      }
      this.mAccumulateStartTimeNanos = paramLong;
      this.mAccumulatedFrames = 0;
      return bool1;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.FpsStabilizer
 * JD-Core Version:    0.7.0.1
 */