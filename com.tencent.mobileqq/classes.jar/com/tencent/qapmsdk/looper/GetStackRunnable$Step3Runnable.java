package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
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
      Logger.INSTANCE.d(new String[] { "QAPM_looper_GetStackRunnable", "Main Thread suspend ", String.valueOf(l), " ms, and the stack is ", str });
      MonitorInfo localMonitorInfo = this.mi;
      localMonitorInfo.stack = str;
      localMonitorInfo.lastStackRequestTime = 0L;
      localMonitorInfo.scene = GetStackRunnable.access$200(this.this$0);
      if (TextUtils.isEmpty(this.mi.scene))
      {
        this.mi.scene = ActivityInfo.getCurrentActivityName();
        this.mi.needCheck = true;
      }
      else
      {
        this.mi.needCheck = false;
      }
    }
    this.stepHandler.post(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable.Step3Runnable
 * JD-Core Version:    0.7.0.1
 */