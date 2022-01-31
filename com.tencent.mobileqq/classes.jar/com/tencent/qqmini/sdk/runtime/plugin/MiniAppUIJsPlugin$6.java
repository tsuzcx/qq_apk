package com.tencent.qqmini.sdk.runtime.plugin;

import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class MiniAppUIJsPlugin$6
  implements Runnable
{
  MiniAppUIJsPlugin$6(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgkd parambgkd) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.b);
      int i = localJSONObject.optInt("htmlId");
      localJSONObject = localJSONObject.optJSONObject("position");
      if (localJSONObject != null)
      {
        int j = localJSONObject.optInt("left");
        int k = localJSONObject.optInt("top");
        int m = localJSONObject.optInt("width");
        int n = localJSONObject.optInt("height");
        if (MiniAppUIJsPlugin.access$1200(this.this$0, i, j, k, m, n))
        {
          this.val$req.a();
          return;
        }
        this.val$req.a("create webview failed.");
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppUIJsPlugin", this.val$req.a + " error.", localException);
      this.val$req.b();
      return;
    }
    this.val$req.b();
    QMLog.e("MiniAppUIJsPlugin", "posObj is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */