package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;

class OskReliableVideoPlayerImpl$6
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  OskReliableVideoPlayerImpl$6(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnVideoSizeChangedListener != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnVideoSizeChangedListener.onVideoSizeChanged(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.6
 * JD-Core Version:    0.7.0.1
 */