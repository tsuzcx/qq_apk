package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class MediaChooseJsPlugin$3
  implements Runnable
{
  MediaChooseJsPlugin$3(MediaChooseJsPlugin paramMediaChooseJsPlugin) {}
  
  public void run()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MediaJsPlugin", "hideToastView toastView=" + MediaChooseJsPlugin.access$100(this.this$0));
    }
    if (MediaChooseJsPlugin.access$100(this.this$0) != null)
    {
      MediaChooseJsPlugin.access$100(this.this$0).hide();
      MediaChooseJsPlugin.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */