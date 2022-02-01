package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("folder_status", this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(ReadInJoyDailyFragment.e().d() / 1000L);
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("entry_time", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTime());
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("postset_time", ((StringBuilder)localObject2).toString());
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("version", VideoReporter.a);
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("os", "1");
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("cmd", ReadInJoyHelper.O());
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).addStringNotThrow("channel_id", KandianDailyReportUtils.h());
    localObject2 = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReadInJoyDailyFragment.e().e() / 1000L);
    PublicAccountReportUtils.a(null, null, (String)localObject2, (String)localObject2, 0, 0, localStringBuilder.toString(), "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).build(), false);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportDuringTime time is");
    ((StringBuilder)localObject1).append(ReadInJoyDailyFragment.e().e() / 1000L);
    QLog.d("ReadInJoyDailyFragment", 2, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */