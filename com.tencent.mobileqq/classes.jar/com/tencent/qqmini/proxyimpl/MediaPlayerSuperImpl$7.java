package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;

class MediaPlayerSuperImpl$7
  implements ISuperPlayer.OnInfoListener
{
  MediaPlayerSuperImpl$7(MediaPlayerSuperImpl paramMediaPlayerSuperImpl, IMediaPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return this.a.onInfo(this.b, paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl.7
 * JD-Core Version:    0.7.0.1
 */