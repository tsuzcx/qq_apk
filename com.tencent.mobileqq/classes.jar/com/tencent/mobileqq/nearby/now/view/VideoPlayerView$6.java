package com.tencent.mobileqq.nearby.now.view;

import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnErrorListener;

class VideoPlayerView$6
  implements IVideoView.OnErrorListener
{
  VideoPlayerView$6(VideoPlayerView paramVideoPlayerView, VideoData paramVideoData) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.b.mReultListener != null) {
      this.b.mReultListener.a(this.a.c, paramInt1, paramInt2, "use sdk play error");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.6
 * JD-Core Version:    0.7.0.1
 */