package com.tencent.qqmini.miniapp.plugin;

import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$6
  implements IMediaPlayer.OnCompletionListener
{
  VideoEmbeddedWidgetClient$6(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onCompletion(IMediaPlayer paramIMediaPlayer)
  {
    long l2 = 0L;
    VideoEmbeddedWidgetClient.access$1402(this.this$0, true);
    VideoEmbeddedWidgetClient.access$002(this.this$0, true);
    if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {}
    try
    {
      if (VideoEmbeddedWidgetClient.access$1500(this.this$0) != null) {
        VideoEmbeddedWidgetClient.access$1500(this.this$0).removeMessages(1001);
      }
      long l1;
      if ((VideoEmbeddedWidgetClient.access$1100(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$1100(this.this$0).booleanValue()))
      {
        l1 = VideoEmbeddedWidgetClient.access$1200(this.this$0).getDuration();
        if (l1 <= 0L) {
          break label327;
        }
        l1 /= 1000L;
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$700(this.this$0));
        paramIMediaPlayer.put("position", VideoEmbeddedWidgetClient.access$1200(this.this$0).getCurrentPosition() / 1000.0D);
        if ((VideoEmbeddedWidgetClient.access$1100(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$1100(this.this$0).booleanValue())) {
          break label332;
        }
        l1 = l2;
      }
      label327:
      label332:
      for (;;)
      {
        paramIMediaPlayer.put("duration", l1);
        paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$800(this.this$0));
        VideoEmbeddedWidgetClient.access$1000(this.this$0, "onXWebVideoTimeUpdate", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$900(this.this$0));
        QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoTimeUpdate = " + paramIMediaPlayer.toString());
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$700(this.this$0));
        paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$800(this.this$0));
        VideoEmbeddedWidgetClient.access$1000(this.this$0, "onXWebVideoEnded", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$900(this.this$0));
        QMLog.d("miniapp-embedded", "evaluateSubcribeJS onXWebVideoEnded = " + paramIMediaPlayer.toString());
        return;
        l1 = 0L;
        break;
      }
      return;
    }
    catch (Throwable paramIMediaPlayer)
    {
      QMLog.e("miniapp-embedded", "VIDEO_EVENT_END  error.", paramIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.6
 * JD-Core Version:    0.7.0.1
 */