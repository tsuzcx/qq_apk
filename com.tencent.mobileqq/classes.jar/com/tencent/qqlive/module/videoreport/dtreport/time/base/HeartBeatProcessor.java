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
    this.mCurrentTimePinProcessor = new TimePinProcessor(this.mIsInForeground);
    reset();
  }
  
  private void notifyReportHeartBeat()
  {
    if (this.mHeartBeatCallback != null) {
      this.mHeartBeatCallback.reportHeartBeat(this.mSessionId, this.mForegroundDuration, this.mBackgroundDuration);
    }
  }
  
  private void notifySaveHeartBeatInfo()
  {
    if (this.mHeartBeatCallback != null) {
      this.mHeartBeatCallback.saveHeartBeatInfo(this.mSessionId, this.mForegroundDuration, this.mBackgroundDuration);
    }
  }
  
  /* Error */
  private void triggerTiming(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mCurrentTimePinProcessor	Lcom/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor;
    //   6: invokevirtual 70	com/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor:stop	()V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 55	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mForegroundDuration	J
    //   14: aload_0
    //   15: getfield 39	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mCurrentTimePinProcessor	Lcom/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor;
    //   18: invokevirtual 74	com/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor:getForegroundDuration	()J
    //   21: ladd
    //   22: putfield 55	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mForegroundDuration	J
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 57	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mBackgroundDuration	J
    //   30: aload_0
    //   31: getfield 39	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mCurrentTimePinProcessor	Lcom/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor;
    //   34: invokevirtual 77	com/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor:getBackgroundDuration	()J
    //   37: ladd
    //   38: putfield 57	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mBackgroundDuration	J
    //   41: aload_0
    //   42: getfield 39	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mCurrentTimePinProcessor	Lcom/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor;
    //   45: invokevirtual 78	com/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor:reset	()V
    //   48: iload_1
    //   49: ifne +10 -> 59
    //   52: aload_0
    //   53: invokespecial 80	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:notifyReportHeartBeat	()V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield 28	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mProcessorState	I
    //   63: ifne -7 -> 56
    //   66: aload_0
    //   67: getfield 39	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:mCurrentTimePinProcessor	Lcom/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor;
    //   70: invokevirtual 83	com/tencent/qqlive/module/videoreport/dtreport/time/base/TimePinProcessor:start	()V
    //   73: aload_0
    //   74: invokespecial 85	com/tencent/qqlive/module/videoreport/dtreport/time/base/HeartBeatProcessor:notifySaveHeartBeatInfo	()V
    //   77: goto -21 -> 56
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	HeartBeatProcessor
    //   0	85	1	paramBoolean	boolean
    //   80	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	80	finally
    //   52	56	80	finally
    //   59	77	80	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor
 * JD-Core Version:    0.7.0.1
 */