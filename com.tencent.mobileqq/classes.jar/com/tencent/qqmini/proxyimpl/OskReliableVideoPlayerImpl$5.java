package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;

class OskReliableVideoPlayerImpl$5
  implements IMediaPlayer.OnSeekCompleteListener
{
  OskReliableVideoPlayerImpl$5(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnSeekCompleteListener != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnSeekCompleteListener.onSeekComplete(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.5
 * JD-Core Version:    0.7.0.1
 */