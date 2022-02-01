package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsPlayManager$4
  implements Runnable
{
  VideoFeedsPlayManager$4(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = VideoFeedsPlayManager.i(this.this$0);
    if (localVideoPlayerWrapper != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      localVideoPlayerWrapper.u();
      if (!VideoFeedsPlayManager.f(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "activity become onPause after videoPlayer.start()， so we need to pause it");
        }
        localVideoPlayerWrapper.w();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.4
 * JD-Core Version:    0.7.0.1
 */