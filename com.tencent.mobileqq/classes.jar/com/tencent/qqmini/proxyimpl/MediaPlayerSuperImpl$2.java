package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

class MediaPlayerSuperImpl$2
  implements ISuperPlayer.OnVideoPreparedListener
{
  MediaPlayerSuperImpl$2(MediaPlayerSuperImpl paramMediaPlayerSuperImpl, IMediaPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    this.a.onPrepared(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl.2
 * JD-Core Version:    0.7.0.1
 */