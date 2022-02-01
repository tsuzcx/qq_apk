package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class VideoJsPlugin$3
  implements Runnable
{
  VideoJsPlugin$3(VideoJsPlugin paramVideoJsPlugin) {}
  
  public void run()
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideToastView toastView=");
      localStringBuilder.append(VideoJsPlugin.access$100(this.this$0));
      QMLog.d("VideoJsPlugin", localStringBuilder.toString());
    }
    if (VideoJsPlugin.access$100(this.this$0) != null)
    {
      VideoJsPlugin.access$100(this.this$0).hide();
      VideoJsPlugin.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */