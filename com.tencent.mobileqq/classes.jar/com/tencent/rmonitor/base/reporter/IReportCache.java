package com.tencent.rmonitor.base.reporter;

import com.tencent.rmonitor.base.reporter.data.ReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/IReportCache;", "", "cacheReportData", "", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "reportCacheData", "reporter", "Lcom/tencent/rmonitor/base/reporter/IReporter;", "updateCacheDataStatus", "dbId", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IReportCache
{
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull IReporter paramIReporter);
  
  public abstract void a(@NotNull ReportData paramReportData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.IReportCache
 * JD-Core Version:    0.7.0.1
 */