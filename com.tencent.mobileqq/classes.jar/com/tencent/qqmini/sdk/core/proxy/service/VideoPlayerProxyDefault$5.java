package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnErrorListener;

class VideoPlayerProxyDefault$5
  implements MediaPlayer.OnErrorListener
{
  VideoPlayerProxyDefault$5(VideoPlayerProxyDefault paramVideoPlayerProxyDefault, VideoPlayerProxy.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$listener != null) {
      this.val$listener.onError(this.this$0, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.5
 * JD-Core Version:    0.7.0.1
 */