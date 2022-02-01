package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;

class VideoPlayerDefault$7
  implements MediaPlayer.OnSeekCompleteListener
{
  VideoPlayerDefault$7(VideoPlayerDefault paramVideoPlayerDefault, AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.val$listener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onSeekComplete(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.7
 * JD-Core Version:    0.7.0.1
 */