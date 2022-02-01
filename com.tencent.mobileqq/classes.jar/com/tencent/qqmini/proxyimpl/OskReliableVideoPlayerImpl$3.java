package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;

class OskReliableVideoPlayerImpl$3
  implements IMediaPlayer.OnCompletionListener
{
  OskReliableVideoPlayerImpl$3(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    paramIMediaPlayer = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnCompletionListener;
    if (paramIMediaPlayer != null) {
      paramIMediaPlayer.onCompletion(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */