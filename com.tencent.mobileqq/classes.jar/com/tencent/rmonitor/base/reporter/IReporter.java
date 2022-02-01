package com.tencent.rmonitor.base.reporter;

import com.tencent.rmonitor.base.reporter.data.ReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/IReporter;", "", "reportNow", "", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "callback", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "ReportCallback", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IReporter
{
  public abstract boolean a(@NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.IReporter
 * JD-Core Version:    0.7.0.1
 */