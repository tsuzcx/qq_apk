package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;

class DefaultMediaPlayer$7
  implements MediaPlayer.OnInfoListener
{
  DefaultMediaPlayer$7(DefaultMediaPlayer paramDefaultMediaPlayer, IMediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return this.val$listener.onInfo(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.7
 * JD-Core Version:    0.7.0.1
 */