package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import android.os.SystemClock;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class TimePinProcessor
  implements ITimeProcessor
{
  private static final String TAG = "TimePinProcessor";
  private long mBackgroundDuration;
  private long mForegroundDuration;
  private boolean mIsInForeground;
  private boolean mIsTimeForbidden;
  private long mPinDeviation;
  private int mProcessorState = -1;
  private long mStartTime;
  
  public TimePinProcessor(boolean paramBoolean, long paramLong)
  {
    this.mIsInForeground = paramBoolean;
    this.mPinDeviation = (paramLong * 2L);
    reset();
  }
  
  private void printErrorLog(long paramLong)
  {
    if (VideoReport.isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("心跳间隔异常，expected interval = ");
      localStringBuilder.append((float)this.mPinDeviation / 2.0F);
      localStringBuilder.append(", actual interval = ");
      localStringBuilder.append(paramLong);
      Log.i("TimePinProcessor", localStringBuilder.toString());
    }
  }
  
  private void triggerTiming()
  {
    try
    {
      boolean bool = this.mIsTimeForbidden;
      if (bool) {
        return;
      }
      if (this.mProcessorState == 0)
      {
        long l2 = SystemClock.elapsedRealtime() - this.mStartTime;
        long l1 = l2;
        if (l2 > this.mPinDeviation)
        {
          l1 = this.mPinDeviation;
          printErrorLog(l1);
        }
        if (this.mIsInForeground) {
          this.mForegroundDuration += l1;
        } else {
          this.mBackgroundDuration += l1;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
      }
      return;
    }
    finally {}
  }
  
  public void forbidTiming(boolean paramBoolean)
  {
    try
    {
      triggerTiming();
      this.mIsTimeForbidden = paramBoolean;
      if (!this.mIsTimeForbidden) {
        this.mStartTime = SystemClock.elapsedRealtime();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getBackgroundDuration()
  {
    try
    {
      long l = this.mBackgroundDuration;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getForegroundDuration()
  {
    try
    {
      long l = this.mForegroundDuration;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.mProcessorState == 0) {
        stop();
      }
      this.mProcessorState = -1;
      this.mForegroundDuration = 0L;
      this.mBackgroundDuration = 0L;
      return;
    }
    finally {}
  }
  
  public void setInForeground(boolean paramBoolean)
  {
    try
    {
      triggerTiming();
      this.mIsInForeground = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void start()
  {
    try
    {
      if (this.mProcessorState == 0) {
        stop();
      }
      this.mProcessorState = 0;
      this.mStartTime = SystemClock.elapsedRealtime();
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      triggerTiming();
      this.mProcessorState = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.TimePinProcessor
 * JD-Core Version:    0.7.0.1
 */