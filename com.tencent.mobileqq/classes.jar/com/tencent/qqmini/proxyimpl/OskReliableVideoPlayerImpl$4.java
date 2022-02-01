package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;

class OskReliableVideoPlayerImpl$4
  implements IMediaPlayer.OnBufferingUpdateListener
{
  OskReliableVideoPlayerImpl$4(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    paramIMediaPlayer = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnBufferingUpdateListener;
    if (paramIMediaPlayer != null) {
      paramIMediaPlayer.onBufferingUpdate(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.4
 * JD-Core Version:    0.7.0.1
 */