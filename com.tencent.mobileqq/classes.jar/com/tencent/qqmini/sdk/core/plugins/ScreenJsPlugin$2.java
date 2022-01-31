package com.tencent.qqmini.sdk.core.plugins;

import bgho;
import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class ScreenJsPlugin$2
  implements Runnable
{
  ScreenJsPlugin$2(ScreenJsPlugin paramScreenJsPlugin, bgkd parambgkd) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.b);
      if (localJSONObject.has("value"))
      {
        double d = localJSONObject.optDouble("value");
        ScreenJsPlugin.setScreenBrightness(this.this$0.mMiniAppContext.a(), (float)d);
        this.val$req.a();
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
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */