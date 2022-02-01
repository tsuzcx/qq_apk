package com.tencent.qqmini.sdk.core.proxy.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener;

class DefaultMediaPlayer$6
  implements MediaPlayer.OnErrorListener
{
  DefaultMediaPlayer$6(DefaultMediaPlayer paramDefaultMediaPlayer, IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return this.val$listener.onError(this.this$0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DefaultMediaPlayer.6
 * JD-Core Version:    0.7.0.1
 */