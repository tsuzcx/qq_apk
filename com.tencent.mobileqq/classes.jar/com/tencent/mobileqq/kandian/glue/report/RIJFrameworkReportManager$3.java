package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;

final class RIJFrameworkReportManager$3
  implements Runnable
{
  RIJFrameworkReportManager$3(int paramInt) {}
  
  public void run()
  {
    if (this.a == 40677) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(this.a), false);
    } else {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(this.a), false);
    }
    int i = this.a;
    if (i == 56) {
      PublicAccountReportUtils.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", VideoReporter.a(i, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager.3
 * JD-Core Version:    0.7.0.1
 */