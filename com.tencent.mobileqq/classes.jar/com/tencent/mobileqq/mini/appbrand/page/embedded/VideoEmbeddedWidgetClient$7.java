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
    long l2 = 0L;
    QLog.d("miniapp-embedded", 1, "VideoManager probeContentFlag getSubThreadHandler start. " + VideoEmbeddedWidgetClient.access$1600(this.this$0));
    long l1 = System.currentTimeMillis();
    Object localObject = OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(VideoEmbeddedWidgetClient.access$1600(this.this$0)));
    int i = VideoManager.getInstance().probeContentFlag((String)localObject);
    QLog.d("miniapp-embedded", 1, "VideoManager probeContentFlag const : " + (System.currentTimeMillis() - l1));
    localObject = this.this$0;
    boolean bool;
    if (i == 5) {
      bool = true;
    }
    for (;;)
    {
      VideoEmbeddedWidgetClient.access$402((VideoEmbeddedWidgetClient)localObject, Boolean.valueOf(bool));
      QLog.d("miniapp-embedded", 1, "VideoManager probeContentFlag isHls : " + VideoEmbeddedWidgetClient.access$400(this.this$0) + "; flag : " + i);
      if (VideoEmbeddedWidgetClient.access$200(this.this$0) != null) {}
      try
      {
        l1 = VideoEmbeddedWidgetClient.access$500(this.this$0).getDuration();
        if (l1 > 0L)
        {
          l1 /= 1000L;
          label197:
          localObject = new JSONObject();
          ((JSONObject)localObject).put("data", VideoEmbeddedWidgetClient.access$600(this.this$0));
          ((JSONObject)localObject).put("videoPlayerId", VideoEmbeddedWidgetClient.access$700(this.this$0));
          if ((VideoEmbeddedWidgetClient.access$400(this.this$0) == null) || (!VideoEmbeddedWidgetClient.access$400(this.this$0).booleanValue())) {
            break label446;
          }
          l1 = l2;
        }
        label446:
        for (;;)
        {
          ((JSONObject)localObject).put("duration", l1);
          ((JSONObject)localObject).put("width", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoWidth() / DisplayUtil.getDensity(VideoEmbeddedWidgetClient.access$200(this.this$0).getContextEx()));
          ((JSONObject)localObject).put("height", VideoEmbeddedWidgetClient.access$500(this.this$0).getVideoHeight() / DisplayUtil.getDensity(VideoEmbeddedWidgetClient.access$200(this.this$0).getContextEx()));
          ((AppBrandRuntime)VideoEmbeddedWidgetClient.access$900(this.this$0)).serviceRuntime.evaluateSubcribeJS("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          VideoEmbeddedWidgetClient.access$200(this.this$0).evaluateSubcribeJS("onXWebVideoLoadedMetaData", ((JSONObject)localObject).toString(), VideoEmbeddedWidgetClient.access$800(this.this$0));
          QLog.d("miniapp-embedded", 2, "MSG_IS_HLS evaluateSubcribeJS onXWebVideoLoadedMetaData = " + ((JSONObject)localObject).toString());
          return;
          bool = false;
          break;
          l1 = 0L;
          break label197;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient.7
 * JD-Core Version:    0.7.0.1
 */