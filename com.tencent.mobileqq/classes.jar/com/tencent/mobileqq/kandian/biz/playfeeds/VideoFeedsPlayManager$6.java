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
    if ((VideoFeedsPlayManager.i(this.this$0) != null) && ((VideoFeedsPlayManager.i(this.this$0).h() == 5) || (VideoFeedsPlayManager.i(this.this$0).h() == 2)))
    {
      VideoFeedsPlayManager.i(this.this$0).v();
      if (VideoFeedsPlayManager.b(this.this$0).o != null) {
        VideoFeedsPlayManager.b(this.this$0).o.e(VideoFeedsPlayManager.b(this.this$0));
      }
      if (VideoFeedsPlayManager.g(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.g(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).f(VideoFeedsPlayManager.b(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.h(this.this$0)) {
        VideoFeedsPlayManager.b(this.this$0).f.i = ReadinjoyAdVideoReportData.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.6
 * JD-Core Version:    0.7.0.1
 */