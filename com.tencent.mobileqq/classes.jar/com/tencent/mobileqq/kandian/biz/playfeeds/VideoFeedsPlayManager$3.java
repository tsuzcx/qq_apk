package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;

class VideoFeedsPlayManager$3
  implements Runnable
{
  VideoFeedsPlayManager$3(VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.l(this.this$0))
    {
      VideoFeedsPlayManager.b(this.this$0, (VideoPlayerWrapper)this.a.h);
      return;
    }
    VideoFeedsPlayManager.c(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.3
 * JD-Core Version:    0.7.0.1
 */