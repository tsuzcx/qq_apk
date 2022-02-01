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
    if (paramInt1 != 3)
    {
      if (paramInt1 != 701)
      {
        if ((paramInt1 == 702) && (VideoEmbeddedWidgetClient.access$600(this.this$0) != null))
        {
          paramIMediaPlayer = this.this$0;
          VideoEmbeddedWidgetClient.access$1300(paramIMediaPlayer, VideoEmbeddedWidgetClient.access$800(paramIMediaPlayer));
        }
      }
      else if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
        try
        {
          paramIMediaPlayer = new JSONObject();
          paramIMediaPlayer.put("data", VideoEmbeddedWidgetClient.access$700(this.this$0));
          paramIMediaPlayer.put("videoPlayerId", VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$1000(this.this$0, "onXWebVideoWaiting", paramIMediaPlayer.toString(), VideoEmbeddedWidgetClient.access$900(this.this$0));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("evaluateSubcribeJS onXWebVideoWaiting = ");
          localStringBuilder.append(paramIMediaPlayer.toString());
          QMLog.d("miniapp-embedded", localStringBuilder.toString());
        }
        catch (Throwable paramIMediaPlayer)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_WAITING  error.", paramIMediaPlayer);
        }
      }
    }
    else if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
      VideoEmbeddedWidgetClient.access$1200(this.this$0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.6
 * JD-Core Version:    0.7.0.1
 */