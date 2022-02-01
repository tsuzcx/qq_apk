package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$5
  implements Runnable
{
  VideoFeedsPlayManager$5(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && (VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_AndroidViewView != null))
    {
      if (VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
        VideoFeedsPlayManager.a(this.this$0).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.c(VideoFeedsPlayManager.a(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).c(VideoFeedsPlayManager.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.5
 * JD-Core Version:    0.7.0.1
 */