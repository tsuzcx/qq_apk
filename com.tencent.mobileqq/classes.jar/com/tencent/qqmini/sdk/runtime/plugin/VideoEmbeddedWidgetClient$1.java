package com.tencent.qqmini.sdk.runtime.plugin;

import android.os.Handler;
import bglu;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$1
  implements IMediaPlayer.OnCompletionListener
{
  VideoEmbeddedWidgetClient$1(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    VideoEmbeddedWidgetClient.access$002(this.this$0, true);
    VideoEmbeddedWidgetClient.access$102(this.this$0, true);
    if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {
      try
      {
        if (VideoEmbeddedWidgetClient.access$300(this.this$0) != null) {
          VideoEmbeddedWidgetClient.access$300(this.this$0).removeMessages(1001);
        }
        if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue()))
        {
          paramIMediaPlayer = new JSONObject();
          paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$500(this.this$0));
          paramIMediaPlayer.put("position", VideoEmbeddedWidgetClient.access$600(this.this$0).getCurrentPosition() / 1000.0D);
          if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {
            break label358;
          }
        }
        label358:
        long l;
        for (double d = 0.0D;; d = l / 1000.0D)
        {
          paramIMediaPlayer.put("duration", d);
          paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
          VideoEmbeddedWidgetClient.access$900(this.this$0).a("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$200(this.this$0).a("onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoTimeUpdate = " + paramIMediaPlayer.toString());
          paramIMediaPlayer = new JSONObject();
          paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$500(this.this$0));
          paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
          VideoEmbeddedWidgetClient.access$900(this.this$0).a("onXWebVideoEnded", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$200(this.this$0).a("onXWebVideoEnded", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoEnded = " + paramIMediaPlayer.toString());
          return;
          l = VideoEmbeddedWidgetClient.access$600(this.this$0).getDuration();
        }
        return;
      }
      catch (Throwable paramIMediaPlayer)
      {
        QMLog.e("miniapp-embedded", "VIDEO_EVENT_END  error.", paramIMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient.1
 * JD-Core Version:    0.7.0.1
 */