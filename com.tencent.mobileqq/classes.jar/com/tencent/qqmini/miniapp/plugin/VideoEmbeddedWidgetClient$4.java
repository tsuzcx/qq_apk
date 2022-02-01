package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.util.TextureRender.VideoTextureRenderer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$4
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  VideoEmbeddedWidgetClient$4(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = new StringBuilder();
    paramIMediaPlayer.append("onVideoSizeChanged : w - ");
    paramIMediaPlayer.append(paramInt1);
    paramIMediaPlayer.append("; h - ");
    paramIMediaPlayer.append(paramInt2);
    QMLog.i("miniapp-embedded", paramIMediaPlayer.toString());
    VideoEmbeddedWidgetClient.access$202(this.this$0, paramInt1);
    VideoEmbeddedWidgetClient.access$302(this.this$0, paramInt2);
    if (VideoEmbeddedWidgetClient.access$400(this.this$0) != null)
    {
      VideoEmbeddedWidgetClient.access$400(this.this$0).setVideoSize(paramInt1, paramInt2, VideoEmbeddedWidgetClient.access$500(this.this$0));
      return;
    }
    QMLog.e("miniapp-embedded", "setOnVideoSizeChangedListener renderer is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */