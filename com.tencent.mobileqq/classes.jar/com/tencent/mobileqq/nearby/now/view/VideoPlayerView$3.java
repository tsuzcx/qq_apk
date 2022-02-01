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
    if (this.a.mVideoInfoListener != null) {
      ((IVideoPlayerView.VideoInfoListener)this.a.mVideoInfoListener).onComplete();
    }
    this.a.mHandler.removeMessages(2025);
    paramIVideoView = VideoPlayerView.access$200(this.a).c;
    int i;
    if (this.a.isVideoCached()) {
      i = 1;
    } else {
      i = 2;
    }
    QualityReporter.a(paramIVideoView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.3
 * JD-Core Version:    0.7.0.1
 */