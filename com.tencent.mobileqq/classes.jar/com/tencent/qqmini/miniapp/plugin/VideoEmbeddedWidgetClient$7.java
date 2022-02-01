package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$7
  implements IMediaPlayer.OnPreparedListener
{
  VideoEmbeddedWidgetClient$7(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    QMLog.d("miniapp-embedded", "onPrepared");
    VideoEmbeddedWidgetClient.access$1702(this.this$0, true);
    this.this$0.sendEvent(Integer.valueOf(5));
    if (VideoEmbeddedWidgetClient.access$1200(this.this$0) != null) {
      VideoEmbeddedWidgetClient.access$1800(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.7
 * JD-Core Version:    0.7.0.1
 */