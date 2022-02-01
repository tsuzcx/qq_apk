package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$3
  implements Runnable
{
  BannerAdPlugin$3(BannerAdPlugin paramBannerAdPlugin, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    boolean bool = ((GameActivity)this.this$0.jsPluginEngine.activityContext).showBannerAd();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "show");
      if (bool) {}
      for (String str = "ok";; str = "error")
      {
        localJSONObject.put("status", str);
        BannerAdPlugin.access$300(this.this$0, this.val$webview, localJSONObject, "onBannerAdShowDone");
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      BannerAdPlugin.access$100(this.this$0, this.val$webview, 1003, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1003)));
      QLog.i("[minigame] BannerAdPlugin", 2, "handle operateBannerAd show error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */