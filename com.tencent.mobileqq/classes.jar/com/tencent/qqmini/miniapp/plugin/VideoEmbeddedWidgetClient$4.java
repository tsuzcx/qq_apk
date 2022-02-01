package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$4
  implements IMediaPlayer.OnInfoListener
{
  VideoEmbeddedWidgetClient$4(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QMLog.d("miniapp-embedded", "onInfo what : " + paramInt1 + "; extra : " + paramInt2 + "; isHls : " + VideoEmbeddedWidgetClient.access$1100(this.this$0));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null)
      {
        VideoEmbeddedWidgetClient.access$1200(this.this$0);
        continue;
        if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null)
        {
          try
          {
            paramIMediaPlayer = new JSONObject();
            paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$700(this.this$0));
            paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$1000(this.this$0, "onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$900(this.this$0));
            QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoWaiting = " + paramIMediaPlayer.toString());
          }
          catch (Throwable paramIMediaPlayer)
          {
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_WAITING  error.", paramIMediaPlayer);
          }
          continue;
          if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
            VideoEmbeddedWidgetClient.access$1300(this.this$0, VideoEmbeddedWidgetClient.access$800(this.this$0));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */