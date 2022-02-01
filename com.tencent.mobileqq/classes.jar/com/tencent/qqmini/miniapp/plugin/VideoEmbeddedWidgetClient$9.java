package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class VideoEmbeddedWidgetClient$9
  implements Runnable
{
  VideoEmbeddedWidgetClient$9(VideoEmbeddedWidgetClient paramVideoEmbeddedWidgetClient) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoManager probeContentFlag getSubThreadHandler start. ");
    ((StringBuilder)localObject).append(VideoEmbeddedWidgetClient.access$2200(this.this$0));
    QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
    long l = System.currentTimeMillis();
    if ((VideoEmbeddedWidgetClient.access$1200(this.this$0) != null) && (!VideoEmbeddedWidgetClient.access$1200(this.this$0).isSuperPlayer()))
    {
      IMediaPlayerUtil localIMediaPlayerUtil = VideoEmbeddedWidgetClient.access$2400(this.this$0);
      if (VideoEmbeddedWidgetClient.access$2300(this.this$0) != null) {
        localObject = ((MiniAppFileManager)VideoEmbeddedWidgetClient.access$2300(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(VideoEmbeddedWidgetClient.access$2200(this.this$0));
      } else {
        localObject = "";
      }
      localObject = localIMediaPlayerUtil.getUrl((String)localObject);
      int i = VideoEmbeddedWidgetClient.access$2400(this.this$0).getContentFlag((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoManager probeContentFlag const : ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
      localObject = this.this$0;
      boolean bool;
      if (i == 5) {
        bool = true;
      } else {
        bool = false;
      }
      VideoEmbeddedWidgetClient.access$1102((VideoEmbeddedWidgetClient)localObject, Boolean.valueOf(bool));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoManager probeContentFlag isHls : ");
      ((StringBuilder)localObject).append(VideoEmbeddedWidgetClient.access$1100(this.this$0));
      ((StringBuilder)localObject).append("; flag : ");
      ((StringBuilder)localObject).append(i);
      QMLog.d("miniapp-embedded", ((StringBuilder)localObject).toString());
    }
    if (VideoEmbeddedWidgetClient.access$600(this.this$0) != null) {
      VideoEmbeddedWidgetClient.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.9
 * JD-Core Version:    0.7.0.1
 */