package com.tencent.qqmini.sdk.runtime.plugin;

import bglu;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$2
  implements IMediaPlayer.OnPreparedListener
{
  VideoEmbeddedWidgetClient$2(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    QMLog.d("miniapp-embedded", "onPrepared");
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
          VideoEmbeddedWidgetClient.access$900(this.this$0).a("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$200(this.this$0).a("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoTimeUpdate onPrepared = " + paramIMediaPlayer.toString());
          return;
          l = VideoEmbeddedWidgetClient.access$600(this.this$0).getDuration();
        }
        return;
      }
      catch (Throwable paramIMediaPlayer)
      {
        QMLog.e("miniapp-embedded", "VIDEO_EVENT_TIME_UPDATE  error.", paramIMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */