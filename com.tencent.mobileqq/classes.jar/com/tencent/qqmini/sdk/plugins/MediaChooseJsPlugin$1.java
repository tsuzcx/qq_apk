package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class MediaChooseJsPlugin$1
  implements Runnable
{
  MediaChooseJsPlugin$1(MediaChooseJsPlugin paramMediaChooseJsPlugin, String paramString) {}
  
  public void run()
  {
    Activity localActivity = MediaChooseJsPlugin.access$000(this.this$0).getAttachedActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (MediaChooseJsPlugin.access$100(this.this$0) == null)
      {
        MediaChooseJsPlugin.access$102(this.this$0, new ToastView(localActivity, (ViewGroup)localActivity.findViewById(16908290)));
        MediaChooseJsPlugin.access$100(this.this$0).show(1, "loading", null, this.val$title, -1, false);
      }
      return;
    }
    QMLog.w("MediaJsPlugin", "showLoading(). Do nothing, activity is null or finishing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */