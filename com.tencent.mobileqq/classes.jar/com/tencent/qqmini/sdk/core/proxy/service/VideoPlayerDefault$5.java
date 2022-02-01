package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;

class VideoPlayerDefault$5
  implements MediaPlayer.OnErrorListener
{
  VideoPlayerDefault$5(VideoPlayerDefault paramVideoPlayerDefault, AbsVideoPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.val$listener != null) {
      this.val$listener.onError(this.this$0, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.5
 * JD-Core Version:    0.7.0.1
 */