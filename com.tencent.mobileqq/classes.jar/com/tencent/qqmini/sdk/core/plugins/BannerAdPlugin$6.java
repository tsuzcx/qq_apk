package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdnw;
import bdyj;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$6
  implements Runnable
{
  BannerAdPlugin$6(BannerAdPlugin paramBannerAdPlugin, int paramInt1, int paramInt2, bdfz parambdfz) {}
  
  public void run()
  {
    boolean bool = this.this$0.updateBannerAdPosition(this.val$resizeType, this.val$resizeValue);
    if ((bool) && (this.val$resizeType == 3)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "resize");
      localJSONObject.put("width", this.val$resizeValue);
      localJSONObject.put("height", bdyj.a(this.val$resizeValue));
      BannerAdPlugin.access$400(this.this$0, this.val$req, localJSONObject, "onBannerAdStateChange");
      if (bdnw.a()) {
        bdnw.b("BannerAdPlugin", "updateBannerAd " + bool + ", resizeValue = " + this.val$resizeValue);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bdnw.d("BannerAdPlugin", "updateBannerAd informJs error", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin.6
 * JD-Core Version:    0.7.0.1
 */