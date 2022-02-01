package com.tencent.mobileqq.nearby.now.view;

import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnInfoListener;

class VideoPlayerView$4
  implements IVideoView.OnInfoListener
{
  VideoPlayerView$4(VideoPlayerView paramVideoPlayerView) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (paramInt == 21) {
      QualityReporter.f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.4
 * JD-Core Version:    0.7.0.1
 */