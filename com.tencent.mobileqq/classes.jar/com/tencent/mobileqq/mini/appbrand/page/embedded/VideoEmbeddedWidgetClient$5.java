package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.page.embedded.TextureRender.VideoTextureRenderer;
import com.tencent.qphone.base.util.QLog;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;

class VideoEmbeddedWidgetClient$5
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  VideoEmbeddedWidgetClient$5(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onVideoSizeChanged(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.i("miniapp-embedded", 1, "onVideoSizeChanged : w - " + paramInt1 + "; h - " + paramInt2);
    VideoEmbeddedWidgetClient.access$1102(this.this$0, paramInt1);
    VideoEmbeddedWidgetClient.access$1202(this.this$0, paramInt2);
    VideoEmbeddedWidgetClient.access$1400(this.this$0).setVideoSize(paramInt1, paramInt2, VideoEmbeddedWidgetClient.access$1300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.5
 * JD-Core Version:    0.7.0.1
 */