package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$5
  implements IMediaPlayer.OnBufferingUpdateListener
{
  VideoEmbeddedWidgetClient$5(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    if ((VideoEmbeddedWidgetClient.access$600(this.this$0) != null) && (!VideoEmbeddedWidgetClient.access$000(this.this$0))) {
      try
      {
        paramIMediaPlayer = new JSONObject();
        paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$700(this.this$0));
        paramIMediaPlayer.put("buffered", paramInt);
        paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$800(this.this$0));
        VideoEmbeddedWidgetClient.access$1000(this.this$0, "onXWebVideoProgress", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$900(this.this$0));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("evaluateSubcribeJS onXWebVideoProgress = ");
        localStringBuilder.append(paramIMediaPlayer.toString());
        QMLog.d("miniapp-embedded", localStringBuilder.toString());
        return;
      }
      catch (Throwable paramIMediaPlayer)
      {
        QMLog.e("miniapp-embedded", "VIDEO_EVENT_PROGRESS  error.", paramIMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.5
 * JD-Core Version:    0.7.0.1
 */