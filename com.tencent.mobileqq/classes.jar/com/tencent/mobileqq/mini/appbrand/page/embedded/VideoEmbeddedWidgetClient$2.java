package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;

class VideoEmbeddedWidgetClient$2
  implements IMediaPlayer.OnErrorListener
{
  VideoEmbeddedWidgetClient$2(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("miniapp-embedded", 2, "onError:i=" + paramInt1 + ",i1=" + paramInt2);
    try
    {
      paramIMediaPlayer = new JSONObject();
      paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
      paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
      ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoError", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoError", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS VIDEO_EVENT_ERR onPrepared = " + paramIMediaPlayer.toString());
      return false;
    }
    catch (Throwable paramIMediaPlayer)
    {
      for (;;)
      {
        QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_TIME_UPDATE  error.", paramIMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */