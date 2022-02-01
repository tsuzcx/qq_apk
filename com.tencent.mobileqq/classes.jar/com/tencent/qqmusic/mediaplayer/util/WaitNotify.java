package com.tencent.qqmusic.mediaplayer.util;

public class WaitNotify
{
  private static final String TAG = "WaitNotify";
  private volatile boolean isWaiting = false;
  private final MonitorObject myMonitorObject = new MonitorObject();
  private volatile boolean wasSignalled = false;
  
  public void doNotify()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("doNotify ");
    ((StringBuilder)???).append(Thread.currentThread().getName());
    Logger.d("WaitNotify", ((StringBuilder)???).toString());
    synchronized (this.myMonitorObject)
    {
      this.wasSignalled = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNotify internal ");
      localStringBuilder.append(Thread.currentThread().getName());
      Logger.d("WaitNotify", localStringBuilder.toString());
      this.myMonitorObject.notifyAll();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNotify over ");
      localStringBuilder.append(Thread.currentThread().getName());
      Logger.d("WaitNotify", localStringBuilder.toString());
      return;
    }
  }
  
  public void doWait()
  {
    doWait(9223372036854775807L, 0, new WaitNotify.1(this));
  }
  
  public void doWait(long paramLong, int paramInt, WaitNotify.WaitListener paramWaitListener)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("doWait ");
    ((StringBuilder)???).append(Thread.currentThread().getName());
    Logger.d("WaitNotify", ((StringBuilder)???).toString());
    int i;
    synchronized (this.myMonitorObject)
    {
      this.wasSignalled = false;
      i = 0;
      boolean bool = this.wasSignalled;
      if (!bool) {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doWait internal ");
          localStringBuilder.append(Thread.currentThread().getName());
          Logger.d("WaitNotify", localStringBuilder.toString());
          this.isWaiting = true;
          if (i < paramInt)
          {
            this.myMonitorObject.wait(paramLong, 0);
            if (!paramWaitListener.keepWaiting())
            {
              doNotify();
              break label207;
            }
          }
          else
          {
            this.myMonitorObject.wait();
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doWait wake ");
          localStringBuilder.append(Thread.currentThread().getName());
          Logger.d("WaitNotify", localStringBuilder.toString());
        }
        catch (InterruptedException localInterruptedException)
        {
          Logger.e("WaitNotify", localInterruptedException.toString());
        }
      }
      label207:
      this.isWaiting = false;
      return;
    }
  }
  
  public boolean isWaiting()
  {
    return this.isWaiting;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.WaitNotify
 * JD-Core Version:    0.7.0.1
 */