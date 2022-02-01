package com.tencent.qqmini.miniapp.plugin;

import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;

class VideoEmbeddedWidgetClient$8
  implements IMediaPlayer.OnCompletionListener
{
  VideoEmbeddedWidgetClient$8(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    VideoEmbeddedWidgetClient.access$1702(this.this$0, true);
    VideoEmbeddedWidgetClient.access$002(this.this$0, true);
    if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null)
    {
      if (VideoEmbeddedWidgetClient.access$1800(this.this$0) != null) {
        VideoEmbeddedWidgetClient.access$1800(this.this$0).removeMessages(1001);
      }
      if ((VideoEmbeddedWidgetClient.access$1100(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$1100(this.this$0).booleanValue())) {
        VideoEmbeddedWidgetClient.access$1600(this.this$0);
      }
      VideoEmbeddedWidgetClient.access$1900(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.8
 * JD-Core Version:    0.7.0.1
 */