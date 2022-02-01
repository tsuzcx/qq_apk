package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$2
  implements IMediaPlayer.OnSeekCompleteListener
{
  VideoEmbeddedWidgetClient$2(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    QMLog.i("miniapp-embedded", "onSeekComplete ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */