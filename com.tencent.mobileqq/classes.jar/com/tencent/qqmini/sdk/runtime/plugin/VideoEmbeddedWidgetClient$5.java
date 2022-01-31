package com.tencent.qqmini.sdk.runtime.plugin;

import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnVideoSizeChangedListener;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.util.TextureRender.VideoTextureRenderer;

class VideoEmbeddedWidgetClient$5
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  VideoEmbeddedWidgetClient$5(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QMLog.i("miniapp-embedded", "onVideoSizeChanged : w - " + paramInt1 + "; h - " + paramInt2);
    VideoEmbeddedWidgetClient.access$1102(this.this$0, paramInt1);
    VideoEmbeddedWidgetClient.access$1202(this.this$0, paramInt2);
    if (VideoEmbeddedWidgetClient.access$1300(this.this$0) != null)
    {
      VideoEmbeddedWidgetClient.access$1300(this.this$0).a(paramInt1, paramInt2, VideoEmbeddedWidgetClient.access$1400(this.this$0));
      return;
    }
    QMLog.e("miniapp-embedded", "setOnVideoSizeChangedListener renderer is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient.5
 * JD-Core Version:    0.7.0.1
 */