package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;

class MediaPlayerSuperImpl$4
  implements ISuperPlayer.OnSeekCompleteListener
{
  MediaPlayerSuperImpl$4(MediaPlayerSuperImpl paramMediaPlayerSuperImpl, IMediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.a.onSeekComplete(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl.4
 * JD-Core Version:    0.7.0.1
 */