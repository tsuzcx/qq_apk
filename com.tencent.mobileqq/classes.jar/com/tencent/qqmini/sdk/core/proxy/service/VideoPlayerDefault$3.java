package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;

class VideoPlayerDefault$3
  implements MediaPlayer.OnPreparedListener
{
  VideoPlayerDefault$3(VideoPlayerDefault paramVideoPlayerDefault, AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.val$listener != null) {
      VideoPlayerDefault.access$502(this.this$0, true);
    }
    this.val$listener.onVideoPrepared(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.3
 * JD-Core Version:    0.7.0.1
 */