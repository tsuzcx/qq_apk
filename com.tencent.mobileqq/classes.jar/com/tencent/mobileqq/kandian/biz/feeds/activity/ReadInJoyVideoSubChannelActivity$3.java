package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;

class ReadInJoyVideoSubChannelActivity$3
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$3(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(ReadInJoyVideoSubChannelActivity.a(this.this$0)), false);
    PublicAccountReportUtils.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.3
 * JD-Core Version:    0.7.0.1
 */