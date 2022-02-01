package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;

class RIJXTabChannelPanelFragment$1
  implements Runnable
{
  RIJXTabChannelPanelFragment$1(RIJXTabChannelPanelFragment paramRIJXTabChannelPanelFragment) {}
  
  public void run()
  {
    RIJChannelReporter.a("0X8009954", new RIJTransMergeKanDianReport.ReportR5Builder().addKandianModeNew().build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabChannelPanelFragment.1
 * JD-Core Version:    0.7.0.1
 */