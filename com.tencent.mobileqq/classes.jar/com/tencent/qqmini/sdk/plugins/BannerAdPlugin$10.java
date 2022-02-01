package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$10
  implements Runnable
{
  BannerAdPlugin$10(BannerAdPlugin paramBannerAdPlugin, String paramString, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", this.a);
      localJSONObject.put("errCode", this.b);
      BannerAdPlugin.access$600(this.this$0, this.c, localJSONObject, "onBannerAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("BannerAdPlugin", "bannerErrorStateCallback error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.10
 * JD-Core Version:    0.7.0.1
 */