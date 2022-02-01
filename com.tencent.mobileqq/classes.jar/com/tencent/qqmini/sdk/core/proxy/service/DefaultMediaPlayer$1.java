package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;

class DefaultMediaPlayer$1
  implements MediaPlayer.OnPreparedListener
{
  DefaultMediaPlayer$1(DefaultMediaPlayer paramDefaultMediaPlayer, IMediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.val$listener.onPrepared(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */