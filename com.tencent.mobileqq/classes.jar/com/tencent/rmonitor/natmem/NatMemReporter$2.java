package com.tencent.rmonitor.natmem;

import com.tencent.rmonitor.base.reporter.IReporter.ReportCallback;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

final class NatMemReporter$2
  implements IReporter.ReportCallback
{
  public void a() {}
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportMemoryCeiling fail! errorCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorMsg = ");
    localStringBuilder.append(paramString);
    localLogger.e(new String[] { "NatMem", localStringBuilder.toString() });
  }
  
  public void t_(int paramInt)
  {
    Logger.b.d(new String[] { "NatMem", "reportMemoryCeiling success!" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.natmem.NatMemReporter.2
 * JD-Core Version:    0.7.0.1
 */