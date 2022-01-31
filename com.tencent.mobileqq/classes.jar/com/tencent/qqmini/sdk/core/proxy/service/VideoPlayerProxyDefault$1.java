package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

class VideoPlayerProxyDefault$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoPlayerProxyDefault$1(VideoPlayerProxyDefault paramVideoPlayerProxyDefault) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoPlayerProxyDefault.access$002(this.this$0, paramInt1);
    VideoPlayerProxyDefault.access$102(this.this$0, paramInt2);
    if (VideoPlayerProxyDefault.access$200(this.this$0) == 0) {
      VideoPlayerProxyDefault.access$300(this.this$0, paramMediaPlayer, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */