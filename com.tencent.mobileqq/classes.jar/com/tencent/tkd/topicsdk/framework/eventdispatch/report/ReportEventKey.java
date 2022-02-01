package com.tencent.tkd.topicsdk.framework.eventdispatch.report;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "EVENT_INVALID", "EVENT_EXPOSURE", "EVENT_DISMISS", "EVENT_CLICK", "EVENT_DRAG", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public enum ReportEventKey
  implements Serializable
{
  static
  {
    ReportEventKey localReportEventKey1 = new ReportEventKey("EVENT_INVALID", 0);
    EVENT_INVALID = localReportEventKey1;
    ReportEventKey localReportEventKey2 = new ReportEventKey("EVENT_EXPOSURE", 1);
    EVENT_EXPOSURE = localReportEventKey2;
    ReportEventKey localReportEventKey3 = new ReportEventKey("EVENT_DISMISS", 2);
    EVENT_DISMISS = localReportEventKey3;
    ReportEventKey localReportEventKey4 = new ReportEventKey("EVENT_CLICK", 3);
    EVENT_CLICK = localReportEventKey4;
    ReportEventKey localReportEventKey5 = new ReportEventKey("EVENT_DRAG", 4);
    EVENT_DRAG = localReportEventKey5;
    $VALUES = new ReportEventKey[] { localReportEventKey1, localReportEventKey2, localReportEventKey3, localReportEventKey4, localReportEventKey5 };
  }
  
  private ReportEventKey() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey
 * JD-Core Version:    0.7.0.1
 */