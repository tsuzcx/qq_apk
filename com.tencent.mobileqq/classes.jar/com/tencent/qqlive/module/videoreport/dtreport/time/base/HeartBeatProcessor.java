package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import com.tencent.qqlive.module.videoreport.task.TimerTaskManager;

public class HeartBeatProcessor
  implements ITimeProcessor
{
  private long mBackgroundDuration;
  private TimePinProcessor mCurrentTimePinProcessor;
  private long mForegroundDuration;
  private HeartBeatProcessor.IHeartBeatCallback mHeartBeatCallback;
  private boolean mIsInForeground;
  private int mProcessorState = -1;
  private String mSessionId;
  private long mTimePinInterval;
  private String mTimePinTaskKey;
  
  public HeartBeatProcessor(boolean paramBoolean, long paramLong)
  {
    this.mIsInForeground = paramBoolean;
    this.mTimePinInterval = paramLong;
    this.mCurrentTimePinProcessor = new TimePinProcessor(this.mIsInForeground, paramLong);
    reset();
  }
  
  private void notifyReportHeartBeat()
  {
    HeartBeatProcessor.IHeartBeatCallback localIHeartBeatCallback = this.mHeartBeatCallback;
    if (localIHeartBeatCallback != null) {
      localIHeartBeatCallback.reportHeartBeat(this.mSessionId, this.mForegroundDuration, this.mBackgroundDuration);
    }
  }
  
  private void notifySaveHeartBeatInfo()
  {
    HeartBeatProcessor.IHeartBeatCallback localIHeartBeatCallback = this.mHeartBeatCallback;
    if (localIHeartBeatCallback != null) {
      localIHeartBeatCallback.saveHeartBeatInfo(this.mSessionId, this.mForegroundDuration, this.mBackgroundDuration);
    }
  }
  
  private void triggerTiming(boolean paramBoolean)
  {
    try
    {
      this.mCurrentTimePinProcessor.stop();
      this.mForegroundDuration += this.mCurrentTimePinProcessor.getForegroundDuration();
      this.mBackgroundDuration += this.mCurrentTimePinProcessor.getBackgroundDuration();
      this.mCurrentTimePinProcessor.reset();
      if (!paramBoolean)
      {
        notifyReportHeartBeat();
      }
      else if (this.mProcessorState == 0)
      {
        this.mCurrentTimePinProcessor.start();
        notifySaveHeartBeatInfo();
      }
      return;
    }
    finally {}
  }
  
  public void forbidTimePinTiming(boolean paramBoolean)
  {
    try
    {
      this.mCurrentTimePinProcessor.forbidTiming(paramBoolean);
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
      this.mTimePinTaskKey = null;
      this.mCurrentTimePinProcessor.reset();
      return;
    }
    finally {}
  }
  
  public void setHeartBeatCallback(HeartBeatProcessor.IHeartBeatCallback paramIHeartBeatCallback)
  {
    this.mHeartBeatCallback = paramIHeartBeatCallback;
  }
  
  public void setInForeground(boolean paramBoolean)
  {
    try
    {
      this.mCurrentTimePinProcessor.setInForeground(paramBoolean);
      this.mIsInForeground = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }
  
  public void start()
  {
    try
    {
      if (this.mProcessorState == 0) {
        stop();
      }
      this.mProcessorState = 0;
      this.mTimePinTaskKey = TimerTaskManager.getInstance().addAsyncTimerTask(new HeartBeatProcessor.1(this), this.mTimePinInterval, this.mTimePinInterval);
      this.mCurrentTimePinProcessor.start();
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      if (this.mProcessorState == 0)
      {
        this.mProcessorState = 1;
        TimerTaskManager.getInstance().cancelTimerTask(this.mTimePinTaskKey);
        this.mTimePinTaskKey = null;
        triggerTiming(false);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor
 * JD-Core Version:    0.7.0.1
 */