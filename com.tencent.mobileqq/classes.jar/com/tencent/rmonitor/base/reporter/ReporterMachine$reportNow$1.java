package com.tencent.rmonitor.base.reporter;

import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/rmonitor/base/reporter/ReporterMachine$reportNow$1", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ReporterMachine$reportNow$1
  implements IReporter.ReportCallback
{
  ReporterMachine$reportNow$1(IReporter.ReportCallback paramReportCallback) {}
  
  public void a()
  {
    IReporter.ReportCallback.DefaultImpls.a(this);
  }
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Object localObject = this.a;
    if (localObject != null) {
      ((IReporter.ReportCallback)localObject).a(paramInt1, paramString, paramInt2);
    }
    ReporterMachine.a.a().a(paramInt2);
    localObject = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportNow-onFailure, dbId: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errorCode: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorMsg: ");
    localStringBuilder.append(paramString);
    ((Logger)localObject).d(new String[] { "RMonitor_base_ReporterMachine", localStringBuilder.toString() });
  }
  
  public void t_(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((IReporter.ReportCallback)localObject).t_(paramInt);
    }
    ReporterMachine.a.a().a(paramInt);
    localObject = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportNow-onSuccess, dbId: ");
    localStringBuilder.append(paramInt);
    ((Logger)localObject).d(new String[] { "RMonitor_base_ReporterMachine", localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.ReporterMachine.reportNow.1
 * JD-Core Version:    0.7.0.1
 */