package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;

final class ReadinjoyReportUtils$4
  implements Runnable
{
  ReadinjoyReportUtils$4(RecentItemChatMsgData paramRecentItemChatMsgData) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    int i;
    if (this.a.mUnreadNum > 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.a.mPosition + 1);
    localReportR5Builder.addStringNotThrow("reddot_position", ((StringBuilder)localObject).toString());
    if (i != 0) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localReportR5Builder.addStringNotThrow("reddot_state", (String)localObject);
    PublicAccountReportUtils.a(null, null, "0X800978E", "0X800978E", 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.4
 * JD-Core Version:    0.7.0.1
 */