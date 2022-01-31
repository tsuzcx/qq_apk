package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnSeekCompleteListener;

class VideoPlayerProxyDefault$7
  implements MediaPlayer.OnSeekCompleteListener
{
  VideoPlayerProxyDefault$7(VideoPlayerProxyDefault paramVideoPlayerProxyDefault, VideoPlayerProxy.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.val$listener != null) {
      this.val$listener.onSeekComplete(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.7
 * JD-Core Version:    0.7.0.1
 */