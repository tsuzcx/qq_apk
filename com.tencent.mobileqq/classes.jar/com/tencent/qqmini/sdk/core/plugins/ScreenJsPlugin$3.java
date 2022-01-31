package com.tencent.qqmini.sdk.core.plugins;

import bglv;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class ScreenJsPlugin$3
  implements Runnable
{
  ScreenJsPlugin$3(ScreenJsPlugin paramScreenJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    try
    {
      if (new JSONObject(this.val$req.b).optBoolean("keepScreenOn")) {
        ScreenJsPlugin.keepScreenOn(this.this$0.mMiniAppContext.a(), true);
      }
      for (;;)
      {
        this.val$req.a();
        return;
        ScreenJsPlugin.keepScreenOn(this.this$0.mMiniAppContext.a(), false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ScreenJsPlugin", localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */