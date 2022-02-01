package com.tencent.qapmsdk.common.reporter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/IReporter;", "", "report", "", "baseJson", "Lcom/tencent/qapmsdk/common/reporter/BaseJsonObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "ReportResultCallback", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface IReporter
{
  public abstract boolean report(@NotNull BaseJsonObject paramBaseJsonObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.reporter.IReporter
 * JD-Core Version:    0.7.0.1
 */