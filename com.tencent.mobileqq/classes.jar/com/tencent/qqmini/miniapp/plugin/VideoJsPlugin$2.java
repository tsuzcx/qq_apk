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
    if (QMLog.isColorLevel()) {
      QMLog.d("VideoJsPlugin", "updateToastMsg toastView=" + VideoJsPlugin.access$100(this.this$0));
    }
    VideoJsPlugin.access$100(this.this$0).updateMsg(this.val$title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */