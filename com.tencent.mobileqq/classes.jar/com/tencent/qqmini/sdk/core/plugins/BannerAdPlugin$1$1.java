package com.tencent.qqmini.sdk.core.plugins;

import betc;
import bfgg;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IBannerAdListener;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$1$1
  implements AdProxy.IBannerAdListener
{
  BannerAdPlugin$1$1(BannerAdPlugin.1 param1) {}
  
  public void onADClicked()
  {
    betc.b("BannerAdPlugin", "duojianwu 1019 onADClicked");
  }
  
  public void onADCloseOverlay()
  {
    betc.b("BannerAdPlugin", "onADCloseOverlay");
  }
  
  public void onADClosed()
  {
    betc.b("BannerAdPlugin", "onADClosed");
  }
  
  public void onADExposure()
  {
    betc.b("BannerAdPlugin", "onADExposure");
  }
  
  public void onADLeftApplication()
  {
    betc.b("BannerAdPlugin", "onADLeftApplication");
  }
  
  public void onADOpenOverlay()
  {
    betc.b("BannerAdPlugin", "onADOpenOverlay");
  }
  
  public void onADReceive()
  {
    betc.b("BannerAdPlugin", "onADReceive");
    if (this.this$1.val$adPosInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "load");
      localJSONObject.put("adUnitId", this.this$1.val$adPosInfo.a);
      localJSONObject.put("left", this.this$1.val$adPosInfo.b);
      localJSONObject.put("top", this.this$1.val$adPosInfo.c);
      localJSONObject.put("width", this.this$1.val$adPosInfo.d);
      localJSONObject.put("height", this.this$1.val$adPosInfo.e);
      localJSONObject.put("realWidth", this.this$1.val$adPosInfo.f);
      localJSONObject.put("realHeight", this.this$1.val$adPosInfo.g);
      BannerAdPlugin.access$400(this.this$1.this$0, this.this$1.val$req, localJSONObject, "onBannerAdStateChange");
      localJSONObject = new JSONObject();
      localJSONObject.put("state", "resize");
      localJSONObject.put("width", this.this$1.val$adPosInfo.f);
      localJSONObject.put("height", this.this$1.val$adPosInfo.g);
      BannerAdPlugin.access$400(this.this$1.this$0, this.this$1.val$req, localJSONObject, "onBannerAdStateChange");
      BannerAdPlugin.access$502(this.this$1.this$0, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("BannerAdPlugin", "informJs success", localJSONException);
    }
  }
  
  public void onNoAD(int paramInt, String paramString)
  {
    betc.b("BannerAdPlugin", "onNoAD, errCode = " + paramInt + ", errMsg = " + paramString);
    BannerAdPlugin.access$300(this.this$1.this$0, this.this$1.val$req, paramInt, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */