package com.tencent.rmonitor.resource.runnable;

import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

class ReportDumpFileTask$1
  implements IReporter.ReportCallback
{
  ReportDumpFileTask$1(ReportDumpFileTask paramReportDumpFileTask) {}
  
  public void a() {}
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDumpFile, errorCode: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorMsg: ");
    localStringBuilder.append(paramString);
    localLogger.e(new String[] { "RMonitor_resource_ReportDumpFileTask", localStringBuilder.toString() });
  }
  
  public void t_(int paramInt)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.runnable.ReportDumpFileTask.1
 * JD-Core Version:    0.7.0.1
 */