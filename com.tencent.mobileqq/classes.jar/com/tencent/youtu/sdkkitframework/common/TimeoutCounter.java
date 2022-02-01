package com.tencent.youtu.sdkkitframework.common;

import com.tencent.youtu.sdkkitframework.framework.YtFSM;

public class TimeoutCounter
{
  private static final String TAG = "TimeoutCounter";
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" cancel");
    YtLogger.i(str, localStringBuilder.toString());
    this.needTimer = false;
  }
  
  public boolean checkTimeout()
  {
    return (this.needTimer) && (this.targetTimeoutMs > 0L) && (System.currentTimeMillis() - this.elaspeTimeMs > this.targetTimeoutMs);
  }
  
  public void init(long paramLong, boolean paramBoolean)
  {
    this.targetTimeoutMs = paramLong;
    this.needShowTimer = paramBoolean;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" init with ");
    localStringBuilder.append(this.targetTimeoutMs);
    YtLogger.i(str, localStringBuilder.toString());
  }
  
  public boolean isRunning()
  {
    return (this.needTimer) && (this.targetTimeoutMs > 0L);
  }
  
  public void reset()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" reset");
    YtLogger.i(str, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.TimeoutCounter
 * JD-Core Version:    0.7.0.1
 */