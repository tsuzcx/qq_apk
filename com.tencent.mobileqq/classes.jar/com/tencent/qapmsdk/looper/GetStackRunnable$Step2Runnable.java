package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.os.SystemClock;

class GetStackRunnable$Step2Runnable
  implements Runnable
{
  private MonitorInfo mi;
  private long requestTimeRef;
  private Handler stepHandler;
  
  public GetStackRunnable$Step2Runnable(GetStackRunnable paramGetStackRunnable, Handler paramHandler, MonitorInfo paramMonitorInfo, long paramLong)
  {
    this.stepHandler = paramHandler;
    this.mi = paramMonitorInfo;
    this.requestTimeRef = paramLong;
  }
  
  public void run()
  {
    long l = SystemClock.uptimeMillis() - this.requestTimeRef;
    if ((l < GetStackRunnable.access$000(this.this$0) - 10) || (l > 100000L))
    {
      this.stepHandler.post(this.this$0);
      return;
    }
    GetStackRunnable.Step3Runnable localStep3Runnable = new GetStackRunnable.Step3Runnable(this.this$0, this.stepHandler, this.mi, this.requestTimeRef);
    this.stepHandler.postDelayed(localStep3Runnable, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable.Step2Runnable
 * JD-Core Version:    0.7.0.1
 */