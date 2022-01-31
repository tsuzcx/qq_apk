package com.tencent.qqmini.sdk.core.plugins;

import beka;
import besl;
import org.json.JSONObject;

class ScreenJsPlugin$1
  implements Runnable
{
  ScreenJsPlugin$1(ScreenJsPlugin paramScreenJsPlugin, beka parambeka) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.b);
      if (localJSONObject.has("value"))
      {
        double d = localJSONObject.optDouble("value");
        ScreenJsPlugin.setScreenBrightness(ScreenJsPlugin.access$000(this.this$0), (float)d);
        this.val$req.a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("ScreenJsPlugin", localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */