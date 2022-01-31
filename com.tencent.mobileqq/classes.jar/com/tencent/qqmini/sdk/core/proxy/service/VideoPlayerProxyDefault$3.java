package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnVideoPreparedListener;

class VideoPlayerProxyDefault$3
  implements MediaPlayer.OnPreparedListener
{
  VideoPlayerProxyDefault$3(VideoPlayerProxyDefault paramVideoPlayerProxyDefault, VideoPlayerProxy.OnVideoPreparedListener paramOnVideoPreparedListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.val$listener != null) {
      VideoPlayerProxyDefault.access$502(this.this$0, true);
    }
    this.val$listener.onVideoPrepared(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.3
 * JD-Core Version:    0.7.0.1
 */