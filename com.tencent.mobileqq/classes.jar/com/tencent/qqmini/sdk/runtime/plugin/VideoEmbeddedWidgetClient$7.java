package com.tencent.qqmini.sdk.runtime.plugin;

import bghn;
import bgjm;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONObject;

class VideoEmbeddedWidgetClient$7
  implements Runnable
{
  VideoEmbeddedWidgetClient$7(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void run()
  {
    QMLog.d("miniapp-embedded", "VideoManager probeContentFlag getSubThreadHandler start. " + VideoEmbeddedWidgetClient.access$1600(this.this$0));
    long l = System.currentTimeMillis();
    Object localObject = VideoEmbeddedWidgetClient.access$1700(this.this$0).getUrl(bgjm.a().a(VideoEmbeddedWidgetClient.access$1600(this.this$0)));
    int i = VideoEmbeddedWidgetClient.access$1700(this.this$0).getContentFlag((String)localObject);
    QMLog.d("miniapp-embedded", "VideoManager probeContentFlag const : " + (System.currentTimeMillis() - l));
    localObject = this.this$0;
    if (i == 5) {}
    for (boolean bool = true;; bool = false)
    {
      VideoEmbeddedWidgetClient.access$402((VideoEmbeddedWidgetClient)localObject, Boolean.valueOf(bool));
      QMLog.d("miniapp-embedded", "VideoManager probeContentFlag isHls : " + VideoEmbeddedWidgetClient.access$400(this.this$0) + "; flag : " + i);
      if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", VideoEmbeddedWidgetClient.access$500(this.this$0));
          ((JSONObject)localObject).put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
          if ((VideoEmbeddedWidgetClient.access$400(this.this$0) != null) && (VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {}
          for (double d = 0.0D;; d = l / 1000.0D)
          {
            ((JSONObject)localObject).put("duration", d);
            ((JSONObject)localObject).put("width", VideoEmbeddedWidgetClient.access$600(this.this$0).getVideoWidth() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
            ((JSONObject)localObject).put("height", VideoEmbeddedWidgetClient.access$600(this.this$0).getVideoHeight() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
            VideoEmbeddedWidgetClient.access$900(this.this$0).a("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$200(this.this$0).a("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            QMLog.d("miniapp-embedded", "MSG_IS_HLS evaluateSubcribeJS onXWebVideoLoadedMetaData = " + ((JSONObject)localObject).toString());
            return;
            l = VideoEmbeddedWidgetClient.access$600(this.this$0).getDuration();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("miniapp-embedded", "VIDEO_EVENT_LOADED_METADATA error.", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClient.7
 * JD-Core Version:    0.7.0.1
 */