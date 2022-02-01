package com.tencent.mobileqq.kandian.glue.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.statistics.ReportController.BusinessDataReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/api/IRIJNewReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createNewReport", "Lcom/tencent/mobileqq/statistics/ReportController$BusinessDataReporter;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJNewReport
  extends QRouteApi
{
  @NotNull
  public abstract ReportController.BusinessDataReporter createNewReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.api.IRIJNewReport
 * JD-Core Version:    0.7.0.1
 */