package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.os.Handler;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;

class VideoEmbeddedWidgetClient$1
  implements IMediaPlayer.OnCompletionListener
{
  VideoEmbeddedWidgetClient$1(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    long l2 = 0L;
    VideoEmbeddedWidgetClient.access$002(this.this$0, true);
    VideoEmbeddedWidgetClient.access$102(this.this$0, true);
    if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {}
    try
    {
      if (VideoEmbeddedWidgetClient.access$300(this.this$0) != null) {
        VideoEmbeddedWidgetClient.access$300(this.this$0).removeMessages(1001);
      }
      long l1;
      if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue()))
      {
        l1 = VideoEmbeddedWidgetClient.access$500(this.this$0).getDuration();
        if (l1 <= 0L) {
          break label401;
        }
        l1 /= 1000L;
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
        paramIMediaPlayer.put("position", VideoEmbeddedWidgetClient.access$500(this.this$0).getCurrentPosition() / 1000.0D);
        if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {
          break label406;
        }
        l1 = l2;
      }
      label401:
      label406:
      for (;;)
      {
        paramIMediaPlayer.put("duration", l1);
        paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
        ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
        VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
        QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoTimeUpdate = " + paramIMediaPlayer.toString());
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
        paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
        ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoEnded", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
        VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoEnded", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
        QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoEnded = " + paramIMediaPlayer.toString());
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable paramIMediaPlayer)
    {
      QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_END  error.", paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */