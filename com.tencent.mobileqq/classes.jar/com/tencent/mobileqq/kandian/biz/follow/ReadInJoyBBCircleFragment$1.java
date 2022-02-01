package com.tencent.mobileqq.kandian.biz.follow;

import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class ReadInJoyBBCircleFragment$1
  implements Runnable
{
  ReadInJoyBBCircleFragment$1(ReadInJoyBBCircleFragment paramReadInJoyBBCircleFragment) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReadInJoyBBCircleFragment.a(this.this$0).d() / 1000L);
    localReportR5Builder.addStringNotThrow("entry_time", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localReportR5Builder.addStringNotThrow("postset_time", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReadInJoyBBCircleFragment.a(this.this$0).e() / 1000L);
    PublicAccountReportUtils.a(null, null, "0X800978C", "0X800978C", 0, 0, localStringBuilder.toString(), "", "", localReportR5Builder.build(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyBBCircleFragment.1
 * JD-Core Version:    0.7.0.1
 */