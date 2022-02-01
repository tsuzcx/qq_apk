package com.tencent.rmonitor.sla;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;

class SLAHelper$1
  implements Runnable
{
  SLAHelper$1(SLAHelper paramSLAHelper) {}
  
  public void run()
  {
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSLAReportInner, begin, isSLAReported: ");
    localStringBuilder.append(SLAHelper.a(this.this$0));
    localLogger.i(new String[] { "RMonitor_sla_SLAHelper", localStringBuilder.toString() });
    if (!SLAHelper.a(this.this$0))
    {
      this.this$0.c();
      BaseInfo.checkDeviceId(BaseInfo.app);
      this.this$0.d();
    }
    localLogger = Logger.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSLAReportInner, end, isSLAReported: ");
    localStringBuilder.append(SLAHelper.a(this.this$0));
    localLogger.i(new String[] { "RMonitor_sla_SLAHelper", localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.sla.SLAHelper.1
 * JD-Core Version:    0.7.0.1
 */