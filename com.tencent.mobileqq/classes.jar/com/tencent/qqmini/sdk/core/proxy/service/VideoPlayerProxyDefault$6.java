package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnInfoListener;

class VideoPlayerProxyDefault$6
  implements MediaPlayer.OnInfoListener
{
  VideoPlayerProxyDefault$6(VideoPlayerProxyDefault paramVideoPlayerProxyDefault, VideoPlayerProxy.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$listener != null) {
      this.val$listener.onInfo(this.this$0, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.6
 * JD-Core Version:    0.7.0.1
 */