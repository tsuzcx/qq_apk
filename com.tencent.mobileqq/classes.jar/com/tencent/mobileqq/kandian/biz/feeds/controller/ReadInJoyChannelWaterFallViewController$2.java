package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;

class ReadInJoyChannelWaterFallViewController$2
  implements Runnable
{
  ReadInJoyChannelWaterFallViewController$2(ReadInJoyChannelWaterFallViewController paramReadInJoyChannelWaterFallViewController) {}
  
  public void run()
  {
    if (ReadInJoyChannelWaterFallViewController.a(this.this$0) == 40677)
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(ReadInJoyChannelWaterFallViewController.a(this.this$0)), false);
      return;
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(ReadInJoyChannelWaterFallViewController.a(this.this$0)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController.2
 * JD-Core Version:    0.7.0.1
 */