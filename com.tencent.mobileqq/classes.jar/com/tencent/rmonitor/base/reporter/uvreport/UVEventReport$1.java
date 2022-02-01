package com.tencent.rmonitor.base.reporter.uvreport;

import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

class UVEventReport$1
  implements IReporter.ReportCallback
{
  UVEventReport$1(UVEventReport paramUVEventReport) {}
  
  public void a() {}
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportPluginStart fail! errorCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorMsg = ");
    localStringBuilder.append(paramString);
    localLogger.e(new String[] { "UVEventReport", localStringBuilder.toString() });
  }
  
  public void t_(int paramInt)
  {
    Logger.b.d(new String[] { "UVEventReport", "reportPluginStart success!" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.uvreport.UVEventReport.1
 * JD-Core Version:    0.7.0.1
 */