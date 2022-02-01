package com.tencent.mobileqq.kandian.biz.diandian.entryview.report;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/entryview/report/RIJEntryViewReport;", "", "()V", "REPORT_MAIN_TAB_ENTRY_VIEW", "", "REPORT_SHOW_DELIVER_PUBLISH_ENTRY_VIEW", "", "REPORT_SHOW_ENTRY_DIALOG", "REPORT_SHOW_ENTRY_VIEW", "REPORT_SHOW_VIDEO_PUBLISH_ENTRY_VIEW", "TAG", "reportPublisherEntryView", "", "actionName", "reportPublisherEntryViewWithPosition", "position", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJEntryViewReport
{
  public static final RIJEntryViewReport a = new RIJEntryViewReport();
  
  @JvmStatic
  public static final void a(@Nullable String paramString)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a().addTime();
    localReportR5Builder.addString("uin", RIJQQAppInterfaceUtil.a());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString, int paramInt)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a().addTime();
    localReportR5Builder.addString("uin", RIJQQAppInterfaceUtil.a());
    localReportR5Builder.addString("position", String.valueOf(paramInt));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.report.RIJEntryViewReport
 * JD-Core Version:    0.7.0.1
 */