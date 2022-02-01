package com.tencent.youtu.sdkkitframework.common;

import com.tencent.youtu.sdkkitframework.framework.YtFSM;

public class TimeoutCounter
{
  private static final String TAG = TimeoutCounter.class.getSimpleName();
  private long elaspeTimeMs = 0L;
  private String name = "timeout counter";
  private boolean needShowTimer = true;
  private boolean needTimer = false;
  private long targetTimeoutMs = 0L;
  
  public TimeoutCounter(String paramString)
  {
    this.name = paramString;
  }
  
  public void cancel()
  {
    YtLogger.i(TAG, this.name + " cancel");
    this.needTimer = false;
  }
  
  public boolean checkTimeout()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.needTimer)
    {
      bool1 = bool2;
      if (this.targetTimeoutMs > 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - this.elaspeTimeMs > this.targetTimeoutMs) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void init(long paramLong, boolean paramBoolean)
  {
    this.targetTimeoutMs = paramLong;
    this.needShowTimer = paramBoolean;
    YtLogger.i(TAG, this.name + " init with " + this.targetTimeoutMs);
  }
  
  public boolean isRunning()
  {
    return (this.needTimer) && (this.targetTimeoutMs > 0L);
  }
  
  public void reset()
  {
    YtLogger.i(TAG, this.name + " reset");
    this.needTimer = true;
    if ((this.targetTimeoutMs > 0L) && (this.needShowTimer)) {
      YtFSM.getInstance().sendFSMEvent(new TimeoutCounter.1(this));
    }
    this.elaspeTimeMs = System.currentTimeMillis();
  }
  
  public void start()
  {
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.TimeoutCounter
 * JD-Core Version:    0.7.0.1
 */