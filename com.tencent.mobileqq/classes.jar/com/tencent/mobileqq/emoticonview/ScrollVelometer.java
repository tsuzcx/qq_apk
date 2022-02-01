package com.tencent.mobileqq.emoticonview;

import android.os.SystemClock;

public class ScrollVelometer
{
  public static final int DEFAULT_CHECK_TIME = 100;
  int mCheckTime = 100;
  int mDistance;
  ScrollVelometer.SpeedListener mListener;
  long mStartTime;
  int mThreshold;
  boolean mWorking = false;
  
  public ScrollVelometer(int paramInt, ScrollVelometer.SpeedListener paramSpeedListener)
  {
    this.mThreshold = paramInt;
    this.mListener = paramSpeedListener;
  }
  
  public void onMove(int paramInt)
  {
    if (!this.mWorking) {
      return;
    }
    this.mDistance += paramInt;
    if (this.mStartTime == 0L)
    {
      this.mStartTime = SystemClock.uptimeMillis();
      return;
    }
    if (SystemClock.uptimeMillis() - this.mStartTime > this.mCheckTime)
    {
      ScrollVelometer.SpeedListener localSpeedListener = this.mListener;
      boolean bool;
      if (this.mDistance > this.mThreshold) {
        bool = true;
      } else {
        bool = false;
      }
      localSpeedListener.onCheckSpeed(bool);
      this.mStartTime = 0L;
      this.mDistance = 0;
    }
  }
  
  public void setCheckTime(int paramInt)
  {
    this.mCheckTime = paramInt;
  }
  
  public void switchOn(boolean paramBoolean)
  {
    this.mWorking = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ScrollVelometer
 * JD-Core Version:    0.7.0.1
 */