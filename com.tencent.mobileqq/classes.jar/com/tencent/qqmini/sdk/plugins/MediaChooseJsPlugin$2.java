package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class MediaChooseJsPlugin$2
  implements Runnable
{
  MediaChooseJsPlugin$2(MediaChooseJsPlugin paramMediaChooseJsPlugin, String paramString) {}
  
  public void run()
  {
    if (MediaChooseJsPlugin.access$100(this.this$0) == null) {
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("MediaJsPlugin", "updateToastMsg toastView=" + MediaChooseJsPlugin.access$100(this.this$0));
    }
    MediaChooseJsPlugin.access$100(this.this$0).updateMsg(this.val$title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */