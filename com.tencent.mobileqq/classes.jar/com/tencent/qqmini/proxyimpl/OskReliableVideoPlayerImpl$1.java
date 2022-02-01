package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnLoopStartListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnLoopStartListener;

class OskReliableVideoPlayerImpl$1
  implements IMediaPlayer.OnLoopStartListener
{
  OskReliableVideoPlayerImpl$1(OskReliableVideoPlayerImpl paramOskReliableVideoPlayerImpl, ReliableVideoPlayer.OnLoopStartListener paramOnLoopStartListener) {}
  
  public void onLoopStart(IMediaPlayer paramIMediaPlayer)
  {
    paramIMediaPlayer = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnLoopStartListener;
    if (paramIMediaPlayer != null) {
      paramIMediaPlayer.onLoopStart(this.jdField_a_of_type_ComTencentQqminiProxyimplOskReliableVideoPlayerImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.OskReliableVideoPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */