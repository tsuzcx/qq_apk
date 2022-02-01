package com.tencent.tkd.topicsdk.framework.eventdispatch.report;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventBusiness;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "BUSINESS_PUBLISHER", "BUSINESS_LIVE", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public enum ReportEventBusiness
  implements Serializable
{
  static
  {
    ReportEventBusiness localReportEventBusiness1 = new ReportEventBusiness("BUSINESS_PUBLISHER", 0);
    BUSINESS_PUBLISHER = localReportEventBusiness1;
    ReportEventBusiness localReportEventBusiness2 = new ReportEventBusiness("BUSINESS_LIVE", 1);
    BUSINESS_LIVE = localReportEventBusiness2;
    $VALUES = new ReportEventBusiness[] { localReportEventBusiness1, localReportEventBusiness2 };
  }
  
  private ReportEventBusiness() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventBusiness
 * JD-Core Version:    0.7.0.1
 */