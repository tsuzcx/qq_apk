package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;

class VideoEmbeddedWidgetClient$4
  implements IMediaPlayer.OnBufferingUpdateListener
{
  VideoEmbeddedWidgetClient$4(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {}
    try
    {
      paramIMediaPlayer = new JSONObject();
      paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
      paramIMediaPlayer.put("buffered", paramInt);
      paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
      ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      QLog.d("miniapp-embedded", 2, "evaluateSubcribeJS onXWebVideoProgress = " + paramIMediaPlayer.toString());
      return;
    }
    catch (Throwable paramIMediaPlayer)
    {
      QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_PROGRESS  error.", paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */