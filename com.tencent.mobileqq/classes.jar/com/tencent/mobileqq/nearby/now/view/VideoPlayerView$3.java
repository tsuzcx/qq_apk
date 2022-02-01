package com.tencent.mobileqq.nearby.now.view;

import android.os.Handler;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnCompletionListener;

class VideoPlayerView$3
  implements IVideoView.OnCompletionListener
{
  VideoPlayerView$3(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener.a();
    }
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
    paramIVideoView = VideoPlayerView.a(this.a).a;
    if (this.a.c()) {}
    for (int i = 1;; i = 2)
    {
      QualityReporter.a(paramIVideoView, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.3
 * JD-Core Version:    0.7.0.1
 */