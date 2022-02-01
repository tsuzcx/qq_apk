package com.tencent.qapmsdk.looper;

import com.tencent.qapmsdk.common.logger.Logger;

class GetStackRunnable$ReportRunnable
  implements Runnable
{
  private long getStackTimeStamp;
  private MonitorInfo mi;
  
  public GetStackRunnable$ReportRunnable(GetStackRunnable paramGetStackRunnable, MonitorInfo paramMonitorInfo, long paramLong)
  {
    this.mi = paramMonitorInfo;
    this.getStackTimeStamp = paramLong;
  }
  
  public void run()
  {
    if ((this.mi.stack != null) && (this.mi.lastGetStackTimeStamp == this.getStackTimeStamp) && (LooperMonitor.mainThreadLooperPrinter != null))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_looper_GetStackRunnable", "report main thread's stack" });
      this.mi.lastGetStackTimeStamp = 0L;
      LooperMonitor.mainThreadLooperPrinter.gotoReport(this.mi, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */