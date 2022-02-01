package com.tencent.youtu.sdkkitframework.common;

import com.tencent.youtu.sdkkitframework.framework.YtFSM;

public class TimeoutCounter
{
  private static final String TAG = TimeoutCounter.class.getSimpleName();
  private long elaspeTimeMs = 0L;
  private boolean needTimer = true;
  private long targetTimeoutMs = 0L;
  
  public void cancel()
  {
    this.needTimer = false;
  }
  
  public boolean checkTimeout()
  {
    if (this.needTimer) {
      return (this.targetTimeoutMs > 0L) && (System.currentTimeMillis() - this.elaspeTimeMs > this.targetTimeoutMs);
    }
    return this.needTimer;
  }
  
  public void init(long paramLong)
  {
    this.targetTimeoutMs = paramLong;
  }
  
  public void reset()
  {
    this.needTimer = true;
    if (this.targetTimeoutMs > 0L) {
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