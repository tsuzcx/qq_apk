package com.tencent.qapmsdk.base.reporter;

import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qapmsdk/base/reporter/ReporterMachine$reportOnce$1", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "successCode", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ReporterMachine$reportOnce$1
  implements IReporter.ReportResultCallback
{
  ReporterMachine$reportOnce$1(IReporter.ReportResultCallback paramReportResultCallback) {}
  
  public void onFailure(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    IReporter.ReportResultCallback localReportResultCallback = this.$callback;
    if (localReportResultCallback != null) {
      localReportResultCallback.onFailure(paramInt1, paramString, paramInt2);
    }
    ReporterMachine.INSTANCE.updateToSendAway("result_objects", paramInt2);
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    IReporter.ReportResultCallback localReportResultCallback = this.$callback;
    if (localReportResultCallback != null) {
      localReportResultCallback.onSuccess(paramInt1, paramInt2);
    }
    ReporterMachine.INSTANCE.updateToSendAway("result_objects", paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ReporterMachine.reportOnce.1
 * JD-Core Version:    0.7.0.1
 */