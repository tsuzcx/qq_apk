package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class VideoJsPlugin$2
  implements Runnable
{
  VideoJsPlugin$2(VideoJsPlugin paramVideoJsPlugin, String paramString) {}
  
  public void run()
  {
    if (VideoJsPlugin.access$100(this.this$0) == null) {
      return;
    }
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateToastMsg toastView=");
      localStringBuilder.append(VideoJsPlugin.access$100(this.this$0));
      QMLog.d("VideoJsPlugin", localStringBuilder.toString());
    }
    VideoJsPlugin.access$100(this.this$0).updateMsg(this.val$title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */