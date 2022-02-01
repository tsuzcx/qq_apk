package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.os.SystemClock;

class GetStackRunnable$Step1Runnable
  implements Runnable
{
  private MonitorInfo mi;
  private Handler stepHandler;
  
  public GetStackRunnable$Step1Runnable(GetStackRunnable paramGetStackRunnable, Handler paramHandler, MonitorInfo paramMonitorInfo)
  {
    this.stepHandler = paramHandler;
    this.mi = paramMonitorInfo;
  }
  
  public void run()
  {
    if (this.mi.lastStackRequestTime != 0L)
    {
      long l1 = this.mi.lastStackRequestTime;
      long l2 = SystemClock.uptimeMillis() - l1 - GetStackRunnable.access$000(this.this$0);
      if (l2 > 100000L)
      {
        this.stepHandler.post(this.this$0);
        return;
      }
      if (l2 < -10L)
      {
        localObject = new GetStackRunnable.Step2Runnable(this.this$0, this.stepHandler, this.mi, l1);
        this.stepHandler.postDelayed((Runnable)localObject, -l2);
        return;
      }
      l2 = SystemClock.uptimeMillis() - l1;
      if ((l2 < GetStackRunnable.access$000(this.this$0) - 10) || (l2 > 100000L))
      {
        this.stepHandler.post(this.this$0);
        return;
      }
      Object localObject = new GetStackRunnable.Step3Runnable(this.this$0, this.stepHandler, this.mi, l1);
      this.stepHandler.postDelayed((Runnable)localObject, 200L);
      return;
    }
    this.stepHandler.post(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable.Step1Runnable
 * JD-Core Version:    0.7.0.1
 */