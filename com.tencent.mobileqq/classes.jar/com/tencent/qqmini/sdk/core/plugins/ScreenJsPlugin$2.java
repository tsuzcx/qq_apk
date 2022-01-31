package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import betc;
import org.json.JSONObject;

class ScreenJsPlugin$2
  implements Runnable
{
  ScreenJsPlugin$2(ScreenJsPlugin paramScreenJsPlugin, bekr parambekr) {}
  
  public void run()
  {
    try
    {
      if (new JSONObject(this.val$req.b).optBoolean("keepScreenOn")) {
        ScreenJsPlugin.keepScreenOn(ScreenJsPlugin.access$000(this.this$0), true);
      }
      for (;;)
      {
        this.val$req.a();
        return;
        ScreenJsPlugin.keepScreenOn(ScreenJsPlugin.access$000(this.this$0), false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("ScreenJsPlugin", localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */