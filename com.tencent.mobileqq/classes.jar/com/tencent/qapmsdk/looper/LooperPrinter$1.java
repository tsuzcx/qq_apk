package com.tencent.qapmsdk.looper;

import android.os.Debug;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.HashMap;

class LooperPrinter$1
  implements IMonitorCallback
{
  LooperPrinter$1(LooperPrinter paramLooperPrinter) {}
  
  public boolean onAfterStack(long paramLong)
  {
    if (!Debug.isDebuggerConnected())
    {
      if (paramLong == 0L) {
        return true;
      }
      paramLong = SystemClock.uptimeMillis() - paramLong;
      if ((LooperPrinter.access$000(this.this$0) != 0L) && (paramLong > 3000L))
      {
        LooperPrinter.access$002(this.this$0, 0L);
        MonitorInfo localMonitorInfo = (MonitorInfo)LooperMonitor.monitorMap.get(LooperPrinter.access$100(this.this$0));
        Logger.INSTANCE.i(new String[] { "QAPM_looper_LooperPrinter", LooperPrinter.access$100(this.this$0), ", cost=", String.valueOf(paramLong), ", more than 3s, force!!", LooperPrinter.access$200(this.this$0) });
        this.this$0.gotoReport(localMonitorInfo, paramLong);
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void onMonitorEnd()
  {
    Looper.getMainLooper().setMessageLogging(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.LooperPrinter.1
 * JD-Core Version:    0.7.0.1
 */