package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;

class MediaPlayerSuperImpl$5
  implements ISuperPlayer.OnVideoSizeChangedListener
{
  MediaPlayerSuperImpl$5(MediaPlayerSuperImpl paramMediaPlayerSuperImpl, IMediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {}
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    this.a.onVideoSizeChanged(this.b, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl.5
 * JD-Core Version:    0.7.0.1
 */