package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class MiniAppUIJsPlugin$8
  implements Runnable
{
  MiniAppUIJsPlugin$8(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.val$req.b).optInt("htmlId");
      if (MiniAppUIJsPlugin.access$1400(this.this$0, i))
      {
        this.val$req.a();
        return;
      }
      this.val$req.b();
      return;
    }
    catch (Exception localException)
    {
      this.val$req.b();
      QMLog.e("MiniAppUIJsPlugin", "removeHtmlWebview error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */