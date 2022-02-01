package com.tencent.rmonitor.base.reporter.batch;

import com.tencent.rmonitor.base.reporter.DataReportSla;
import com.tencent.rmonitor.sla.AttaReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class ReportCacheImpl$reportCacheData$2
  implements Runnable
{
  public static final 2 a = new 2();
  
  public final void run()
  {
    AttaReporter localAttaReporter = AttaReporter.a();
    DataReportSla localDataReportSla = DataReportSla.a();
    Intrinsics.checkExpressionValueIsNotNull(localDataReportSla, "DataReportSla.getInstance()");
    localAttaReporter.a(localDataReportSla.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.batch.ReportCacheImpl.reportCacheData.2
 * JD-Core Version:    0.7.0.1
 */