package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class ScreenJsPlugin$3
  implements Runnable
{
  ScreenJsPlugin$3(ScreenJsPlugin paramScreenJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      if (new JSONObject(this.val$req.jsonParams).optBoolean("keepScreenOn")) {
        ScreenJsPlugin.keepScreenOn(ScreenJsPlugin.access$300(this.this$0).getAttachedActivity(), true);
      } else {
        ScreenJsPlugin.keepScreenOn(ScreenJsPlugin.access$400(this.this$0).getAttachedActivity(), false);
      }
      this.val$req.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ScreenJsPlugin", localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */