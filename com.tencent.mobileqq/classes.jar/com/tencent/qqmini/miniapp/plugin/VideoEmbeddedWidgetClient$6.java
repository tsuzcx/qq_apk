package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$6
  implements IMediaPlayer.OnInfoListener
{
  VideoEmbeddedWidgetClient$6(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = new StringBuilder();
    paramIMediaPlayer.append("onInfo what : ");
    paramIMediaPlayer.append(paramInt1);
    paramIMediaPlayer.append("; extra : ");
    paramIMediaPlayer.append(paramInt2);
    paramIMediaPlayer.append("; isHls : ");
    paramIMediaPlayer.append(VideoEmbeddedWidgetClient.access$1100(this.this$0));
    QMLog.d("miniapp-embedded", paramIMediaPlayer.toString());
    paramInt2 = paramInt1;
    if (VideoEmbeddedWidgetClient.access$1200(this.this$0).isSuperPlayer())
    {
      QMLog.d("miniapp-embedded", "isSuperPlayer");
      paramInt2 = VideoEmbeddedWidgetClient.access$1300(this.this$0, paramInt1);
    }
    if (paramInt2 != 3)
    {
      if (paramInt2 != 107)
      {
        if (paramInt2 != 108)
        {
          if (paramInt2 != 701)
          {
            if (paramInt2 != 702) {
              return false;
            }
            if (VideoEmbeddedWidgetClient.access$600(this.this$0) == null) {
              break label364;
            }
            QMLog.d("miniapp-embedded", "superPlayer buffering end.");
            VideoEmbeddedWidgetClient.access$1500(this.this$0);
            paramIMediaPlayer = this.this$0;
            VideoEmbeddedWidgetClient.access$1600(paramIMediaPlayer, VideoEmbeddedWidgetClient.access$800(paramIMediaPlayer));
            return false;
          }
          if (VideoEmbeddedWidgetClient.access$600(this.this$0) == null) {
            break label364;
          }
          try
          {
            QMLog.d("miniapp-embedded", "superPlayer buffering start.");
            paramIMediaPlayer = new JSONObject();
            paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$700(this.this$0));
            paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$1000(this.this$0, "onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$900(this.this$0));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("evaluateSubcribeJS onXWebVideoWaiting = ");
            localStringBuilder.append(paramIMediaPlayer.toString());
            QMLog.d("miniapp-embedded", localStringBuilder.toString());
            return false;
          }
          catch (Throwable paramIMediaPlayer)
          {
            QMLog.e("miniapp-embedded", "VIDEO_EVENT_WAITING  error.", paramIMediaPlayer);
            return false;
          }
        }
        if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null)
        {
          QMLog.d("miniapp-embedded", "superPlayer loop end.");
          return false;
        }
      }
      else if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null)
      {
        QMLog.d("miniapp-embedded", "superPlayer loop start.");
        VideoEmbeddedWidgetClient.access$002(this.this$0, false);
        VideoEmbeddedWidgetClient.access$100(this.this$0, 250L);
        return false;
      }
    }
    else if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
      VideoEmbeddedWidgetClient.access$1400(this.this$0);
    }
    label364:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.6
 * JD-Core Version:    0.7.0.1
 */