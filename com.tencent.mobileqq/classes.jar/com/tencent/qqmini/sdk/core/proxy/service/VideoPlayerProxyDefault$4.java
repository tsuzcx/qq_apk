package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCompletionListener;

class VideoPlayerProxyDefault$4
  implements MediaPlayer.OnCompletionListener
{
  VideoPlayerProxyDefault$4(VideoPlayerProxyDefault paramVideoPlayerProxyDefault, VideoPlayerProxy.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.val$listener != null) {
      this.val$listener.onCompletion(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.4
 * JD-Core Version:    0.7.0.1
 */