package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;

class VideoPlayerDefault$4
  implements MediaPlayer.OnCompletionListener
{
  VideoPlayerDefault$4(VideoPlayerDefault paramVideoPlayerDefault, AbsVideoPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.val$listener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onCompletion(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.4
 * JD-Core Version:    0.7.0.1
 */