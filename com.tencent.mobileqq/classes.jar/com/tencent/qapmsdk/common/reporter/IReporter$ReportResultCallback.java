package com.tencent.qapmsdk.common.reporter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "successCode", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface IReporter$ReportResultCallback
{
  public abstract void onFailure(int paramInt1, @NotNull String paramString, int paramInt2);
  
  public abstract void onSuccess(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback
 * JD-Core Version:    0.7.0.1
 */