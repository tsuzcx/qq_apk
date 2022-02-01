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
    if ((VideoFeedsPlayManager.i(this.this$0) != null) && (VideoFeedsPlayManager.b(this.this$0).b != null))
    {
      if (VideoFeedsPlayManager.b(this.this$0).o != null) {
        VideoFeedsPlayManager.b(this.this$0).o.c(VideoFeedsPlayManager.b(this.this$0));
      }
      if (VideoFeedsPlayManager.g(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.g(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).c(VideoFeedsPlayManager.b(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.5
 * JD-Core Version:    0.7.0.1
 */