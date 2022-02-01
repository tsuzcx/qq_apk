package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import aclj;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$5
  implements Runnable
{
  BannerAdPlugin$5(BannerAdPlugin paramBannerAdPlugin, int paramInt1, int paramInt2, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    boolean bool = ((GameActivity)this.this$0.jsPluginEngine.activityContext).updateBannerAdPosition(this.val$resizeType, this.val$resizeValue);
    if ((bool) && (this.val$resizeType == 3)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "resize");
      localJSONObject.put("width", this.val$resizeValue);
      localJSONObject.put("height", aclj.a(0, this.val$resizeValue));
      BannerAdPlugin.access$300(this.this$0, this.val$webview, localJSONObject, "onBannerAdStateChange");
      QLog.i("[minigame] BannerAdPlugin", 1, "updateBannerAd " + bool + ", resizeValue = " + this.val$resizeValue);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[minigame] BannerAdPlugin", 1, "updateBannerAd informJs error", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.5
 * JD-Core Version:    0.7.0.1
 */