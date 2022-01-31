package com.tencent.qqmini.sdk.core.plugins;

import beka;
import besl;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$7
  implements Runnable
{
  BannerAdPlugin$7(BannerAdPlugin paramBannerAdPlugin, String paramString, int paramInt, beka parambeka) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", this.val$errMsg);
      localJSONObject.put("errCode", this.val$errorCode);
      BannerAdPlugin.access$400(this.this$0, this.val$req, localJSONObject, "onBannerAdStateChange");
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("BannerAdPlugin", "bannerErrorStateCallback error", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin.7
 * JD-Core Version:    0.7.0.1
 */