package com.tencent.mobileqq.mini.appbrand.page.embedded;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

class VideoEmbeddedWidgetClient$7
  implements Runnable
{
  VideoEmbeddedWidgetClient$7(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void run()
  {
    QLog.d("miniapp-embedded", 1, "VideoManager probeContentFlag getSubThreadHandler start. " + VideoEmbeddedWidgetClient.access$1600(this.this$0));
    long l = System.currentTimeMillis();
    Object localObject = OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(VideoEmbeddedWidgetClient.access$1600(this.this$0)));
    int i = VideoManager.getInstance().probeContentFlag((String)localObject);
    QLog.d("miniapp-embedded", 1, "VideoManager probeContentFlag const : " + (System.currentTimeMillis() - l));
    localObject = this.this$0;
    if (i == 5) {}
    for (boolean bool = true;; bool = false)
    {
      VideoEmbeddedWidgetClient.access$402((VideoEmbeddedWidgetClient)localObject, Boolean.valueOf(bool));
      QLog.d("miniapp-embedded", 1, "VideoManager probeContentFlag isHls : " + VideoEmbeddedWidgetClient.access$400(this.this$0) + "; flag : " + i);
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
            ((JSONObject)localObject).put("width", VideoEmbeddedWidgetClient.access$600(this.this$0).getVideoWidth() / DisplayUtil.getDensity(VideoEmbeddedWidgetClient.access$200(this.this$0).getContextEx()));
            ((JSONObject)localObject).put("height", VideoEmbeddedWidgetClient.access$600(this.this$0).getVideoHeight() / DisplayUtil.getDensity(VideoEmbeddedWidgetClient.access$200(this.this$0).getContextEx()));
            ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
            QLog.d("miniapp-embedded", 2, "MSG_IS_HLS evaluateSubcribeJS onXWebVideoLoadedMetaData = " + ((JSONObject)localObject).toString());
            return;
            l = VideoEmbeddedWidgetClient.access$600(this.this$0).getDuration();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("miniapp-embedded", 1, "VIDEO_EVENT_LOADED_METADATA error.", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.7
 * JD-Core Version:    0.7.0.1
 */