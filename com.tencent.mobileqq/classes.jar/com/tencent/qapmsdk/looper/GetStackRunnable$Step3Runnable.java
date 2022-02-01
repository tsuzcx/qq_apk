package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qapmsdk.common.logger.Logger;

class GetStackRunnable$Step3Runnable
  implements Runnable
{
  private MonitorInfo mi;
  private long requestTimeRef;
  private Handler stepHandler;
  
  public GetStackRunnable$Step3Runnable(GetStackRunnable paramGetStackRunnable, Handler paramHandler, MonitorInfo paramMonitorInfo, long paramLong)
  {
    this.stepHandler = paramHandler;
    this.mi = paramMonitorInfo;
    this.requestTimeRef = paramLong;
  }
  
  public void run()
  {
    long l = SystemClock.uptimeMillis() - this.mi.lastStackRequestTime;
    if ((this.requestTimeRef == this.mi.lastStackRequestTime) && (l >= GetStackRunnable.access$000(this.this$0) + 200 - 10) && (l < 100000L))
    {
      this.mi.cacheRealStackTime = System.currentTimeMillis();
      String str = GetStackRunnable.access$100(this.this$0, true);
      Logger.INSTANCE.i(new String[] { "QAPM_looper_GetStackRunnable", "Main Thread suspend " + l + " ms, and the stack is " + str });
      this.mi.stack = str;
      this.mi.lastStackRequestTime = 0L;
      this.mi.lastGetStackTimeStamp = this.mi.cacheRealStackTime;
      this.stepHandler.postDelayed(new GetStackRunnable.ReportRunnable(this.this$0, this.mi, this.mi.lastGetStackTimeStamp), 3000L);
    }
    this.stepHandler.post(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable.Step3Runnable
 * JD-Core Version:    0.7.0.1
 */