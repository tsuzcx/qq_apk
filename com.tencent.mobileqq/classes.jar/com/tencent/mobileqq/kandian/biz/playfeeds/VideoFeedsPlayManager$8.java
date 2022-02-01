package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;

class VideoFeedsPlayManager$8
  implements Runnable
{
  VideoFeedsPlayManager$8(VideoFeedsPlayManager paramVideoFeedsPlayManager, ReadInJoyVideoReportData paramReadInJoyVideoReportData) {}
  
  public void run()
  {
    RIJStatisticCollectorReport.a(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.d(), true, this.a.a());
    QualityReporter.a(this.a);
    RIJStatisticCollectorReport.a(this.a.j, this.a.T, this.a.G, this.a.g, this.a.o, 409409, this.a.k, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.8
 * JD-Core Version:    0.7.0.1
 */