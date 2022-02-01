package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;

class DefaultMediaPlayer$2
  implements MediaPlayer.OnCompletionListener
{
  DefaultMediaPlayer$2(DefaultMediaPlayer paramDefaultMediaPlayer, IMediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.val$listener.onCompletion(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.2
 * JD-Core Version:    0.7.0.1
 */