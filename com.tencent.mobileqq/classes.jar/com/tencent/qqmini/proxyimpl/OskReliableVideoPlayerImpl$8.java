package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class OskReliableVideoPlayerImpl$8
  implements IMediaPlayer.OnInfoListener
{
  OskReliableVideoPlayerImpl$8(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnInfoListener;
    if (paramIMediaPlayer != null) {
      return paramIMediaPlayer.onInfo(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.8
 * JD-Core Version:    0.7.0.1
 */