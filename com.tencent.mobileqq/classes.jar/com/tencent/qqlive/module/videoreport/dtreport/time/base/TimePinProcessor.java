package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import android.os.SystemClock;

public class TimePinProcessor
  implements ITimeProcessor
{
  private long mBackgroundDuration;
  private long mForegroundDuration;
  private boolean mIsInForeground;
  private boolean mIsTimeForbidden;
  private int mProcessorState = -1;
  private long mStartTime;
  
  public TimePinProcessor(boolean paramBoolean)
  {
    this.mIsInForeground = paramBoolean;
    reset();
  }
  
  private void triggerTiming()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mIsTimeForbidden;
        if (bool) {
          return;
        }
        if (this.mProcessorState == 0) {
          if (this.mIsInForeground)
          {
            this.mForegroundDuration += SystemClock.elapsedRealtime() - this.mStartTime;
            this.mStartTime = SystemClock.elapsedRealtime();
          }
          else
          {
            this.mBackgroundDuration += SystemClock.elapsedRealtime() - this.mStartTime;
          }
        }
      }
      finally {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.TimePinProcessor
 * JD-Core Version:    0.7.0.1
 */