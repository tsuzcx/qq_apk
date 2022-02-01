package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;

class VideoJsPlugin$1
  implements Runnable
{
  VideoJsPlugin$1(VideoJsPlugin paramVideoJsPlugin, String paramString) {}
  
  public void run()
  {
    Activity localActivity = VideoJsPlugin.access$000(this.this$0).getAttachedActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (VideoJsPlugin.access$100(this.this$0) == null)
      {
        VideoJsPlugin.access$102(this.this$0, new ToastView(localActivity, (ViewGroup)localActivity.findViewById(16908290)));
        VideoJsPlugin.access$100(this.this$0).show(1, "loading", null, this.val$title, -1, false);
        return;
      }
      VideoJsPlugin.access$100(this.this$0).updateMsg(this.val$title);
      return;
    }
    QMLog.w("VideoJsPlugin", "showLoading(). Do nothing, activity is null or finishing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */