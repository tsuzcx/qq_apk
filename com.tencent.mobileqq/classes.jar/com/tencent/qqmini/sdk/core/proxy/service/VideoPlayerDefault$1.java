package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

class VideoPlayerDefault$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoPlayerDefault$1(VideoPlayerDefault paramVideoPlayerDefault) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoPlayerDefault.access$002(this.this$0, paramInt1);
    VideoPlayerDefault.access$102(this.this$0, paramInt2);
    if (VideoPlayerDefault.access$200(this.this$0) == 0) {
      VideoPlayerDefault.access$300(this.this$0, paramMediaPlayer, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.1
 * JD-Core Version:    0.7.0.1
 */