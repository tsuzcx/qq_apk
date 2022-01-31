package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnSeekCompleteListener;

class DefaultMediaPlayer$4
  implements MediaPlayer.OnSeekCompleteListener
{
  DefaultMediaPlayer$4(DefaultMediaPlayer paramDefaultMediaPlayer, IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    this.val$listener.onSeekComplete(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.4
 * JD-Core Version:    0.7.0.1
 */