package com.tencent.qqmini.sdk.runtime.plugin;

import bglu;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

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
      paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$500(this.this$0));
      paramIMediaPlayer.put("buffered", paramInt);
      paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
      VideoEmbeddedWidgetClient.access$900(this.this$0).a("onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      VideoEmbeddedWidgetClient.access$200(this.this$0).a("onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
      QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoProgress = " + paramIMediaPlayer.toString());
      return;
    }
    catch (Throwable paramIMediaPlayer)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_PROGRESS  error.", paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */