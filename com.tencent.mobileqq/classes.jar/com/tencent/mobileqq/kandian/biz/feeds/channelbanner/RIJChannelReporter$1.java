package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

final class RIJChannelReporter$1
  implements Runnable
{
  RIJChannelReporter$1(TabChannelCoverInfo paramTabChannelCoverInfo, BaseReportData paramBaseReportData, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = ChannelListDynamicOrderConfigHandler.b(ReadInJoyUtils.b(), this.a.mChannelCoverId);
      RIJChannelReporter.a("0X8009954", new RIJTransMergeKanDianReport.ReportR5Builder().addChannelId(this.a.mChannelCoverId).addFolderStatus().addRedDotStatus(RIJChannelHelper.a(this.a)).addLocation(this.b.D + 1).addType(this.c).addStringNotThrow("is_change", i).addStringNotThrow("style", 0).build());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QLog.d("RIJChannelReporter", 2, new Object[] { "reportChannelExposure exception ", localJSONException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter.1
 * JD-Core Version:    0.7.0.1
 */