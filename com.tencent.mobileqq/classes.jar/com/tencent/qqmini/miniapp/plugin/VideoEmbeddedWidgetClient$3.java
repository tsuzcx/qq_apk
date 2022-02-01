package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$3
  implements IMediaPlayer.OnErrorListener
{
  VideoEmbeddedWidgetClient$3(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = new StringBuilder();
    paramIMediaPlayer.append("onError : what - ");
    paramIMediaPlayer.append(paramInt1);
    paramIMediaPlayer.append("; extra - ");
    paramIMediaPlayer.append(paramInt2);
    QMLog.i("miniapp-embedded", paramIMediaPlayer.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.3
 * JD-Core Version:    0.7.0.1
 */