package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

class VideoEmbeddedWidgetClient$2
  implements IMediaPlayer.OnPreparedListener
{
  VideoEmbeddedWidgetClient$2(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    QLog.d("miniapp-embedded", 2, "onPrepared");
    VideoEmbeddedWidgetClient.access$1002(this.this$0, true);
    this.this$0.sendEvent(Integer.valueOf(5));
    if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
      try
      {
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$500(this.this$0));
        paramIMediaPlayer.put("position", VideoEmbeddedWidgetClient.access$600(this.this$0).getCurrentPosition() / 1000.0D);
        if ((VideoEmbeddedWidgetClient.access$400(this.this$0) != null) && (VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {}
        long l;
        for (double d = 0.0D;; d = l / 1000.0D)
        {
          paramIMediaPlayer.put("duration", d);
          paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
          ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoTimeUpdate onPrepared = " + paramIMediaPlayer.toString());
          return;
          l = VideoEmbeddedWidgetClient.access$600(this.this$0).getDuration();
        }
        return;
      }
      catch (Throwable paramIMediaPlayer)
      {
        QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_TIME_UPDATE  error.", paramIMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */