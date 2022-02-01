package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$6
  implements Runnable
{
  VideoFeedsPlayManager$6(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && ((VideoFeedsPlayManager.a(this.this$0).b() == 5) || (VideoFeedsPlayManager.a(this.this$0).b() == 2)))
    {
      VideoFeedsPlayManager.a(this.this$0).e();
      if (VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.e(VideoFeedsPlayManager.a(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).f(VideoFeedsPlayManager.a(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.c(this.this$0)) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.6
 * JD-Core Version:    0.7.0.1
 */