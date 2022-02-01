package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$7
  implements Runnable
{
  VideoEmbeddedWidgetClient$7(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void run()
  {
    QMLog.d("miniapp-embedded", "VideoManager probeContentFlag getSubThreadHandler start. " + VideoEmbeddedWidgetClient.access$2000(this.this$0));
    long l = System.currentTimeMillis();
    IMediaPlayerUtil localIMediaPlayerUtil = VideoEmbeddedWidgetClient.access$2200(this.this$0);
    Object localObject;
    int i;
    if (VideoEmbeddedWidgetClient.access$2100(this.this$0) != null)
    {
      localObject = ((MiniAppFileManager)VideoEmbeddedWidgetClient.access$2100(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(VideoEmbeddedWidgetClient.access$2000(this.this$0));
      localObject = localIMediaPlayerUtil.getUrl((String)localObject);
      i = VideoEmbeddedWidgetClient.access$2200(this.this$0).getContentFlag((String)localObject);
      QMLog.d("miniapp-embedded", "VideoManager probeContentFlag const : " + (System.currentTimeMillis() - l));
      localObject = this.this$0;
      if (i != 5) {
        break label225;
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      VideoEmbeddedWidgetClient.access$1102((VideoEmbeddedWidgetClient)localObject, Boolean.valueOf(bool));
      QMLog.d("miniapp-embedded", "VideoManager probeContentFlag isHls : " + VideoEmbeddedWidgetClient.access$1100(this.this$0) + "; flag : " + i);
      if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
        VideoEmbeddedWidgetClient.access$1200(this.this$0);
      }
      return;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.7
 * JD-Core Version:    0.7.0.1
 */