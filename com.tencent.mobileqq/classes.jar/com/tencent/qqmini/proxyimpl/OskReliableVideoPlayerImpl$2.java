package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

class OskReliableVideoPlayerImpl$2
  implements IMediaPlayer.OnPreparedListener
{
  OskReliableVideoPlayerImpl$2(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnPreparedListener != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnPreparedListener.onPrepared(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */