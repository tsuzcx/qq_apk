package com.tencent.mobileqq.kandian.glue.report.api.impl;

import com.tencent.mobileqq.kandian.glue.report.api.IRIJNewReport;
import com.tencent.mobileqq.kandian.repo.report.RIJNewReporter;
import com.tencent.mobileqq.statistics.ReportController.BusinessDataReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/impl/RIJNewReportImpl;", "Lcom/tencent/mobileqq/kandian/glue/report/api/IRIJNewReport;", "()V", "createNewReport", "Lcom/tencent/mobileqq/statistics/ReportController$BusinessDataReporter;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJNewReportImpl
  implements IRIJNewReport
{
  @NotNull
  public ReportController.BusinessDataReporter createNewReport()
  {
    return (ReportController.BusinessDataReporter)new RIJNewReporter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.impl.RIJNewReportImpl
 * JD-Core Version:    0.7.0.1
 */