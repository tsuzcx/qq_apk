package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$1$1
  implements AdProxy.IBannerAdListener
{
  BannerAdPlugin$1$1(BannerAdPlugin.1 param1) {}
  
  public void onADClicked()
  {
    QMLog.i("BannerAdPlugin", "onADClicked");
  }
  
  public void onADCloseOverlay()
  {
    QMLog.i("BannerAdPlugin", "onADCloseOverlay");
  }
  
  public void onADClosed()
  {
    QMLog.i("BannerAdPlugin", "onADClosed");
  }
  
  public void onADExposure()
  {
    QMLog.i("BannerAdPlugin", "onADExposure");
  }
  
  public void onADLeftApplication()
  {
    QMLog.i("BannerAdPlugin", "onADLeftApplication");
  }
  
  public void onADOpenOverlay()
  {
    QMLog.i("BannerAdPlugin", "onADOpenOverlay");
  }
  
  public void onADReceive()
  {
    QMLog.i("BannerAdPlugin", "onADReceive");
    if (this.this$1.val$adPosInfo == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "load");
      localJSONObject.put("adUnitId", this.this$1.val$adPosInfo.mAdUnitId);
      localJSONObject.put("left", this.this$1.val$adPosInfo.mAdLeft);
      localJSONObject.put("top", this.this$1.val$adPosInfo.mAdTop);
      localJSONObject.put("width", this.this$1.val$adPosInfo.mAdWidth);
      localJSONObject.put("height", this.this$1.val$adPosInfo.mAdHeight);
      localJSONObject.put("realWidth", this.this$1.val$adPosInfo.mAdRealWidth);
      localJSONObject.put("realHeight", this.this$1.val$adPosInfo.mAdRealHeight);
      BannerAdPlugin.access$600(this.this$1.this$0, this.this$1.val$req, localJSONObject, "onBannerAdStateChange");
      localJSONObject = new JSONObject();
      localJSONObject.put("state", "resize");
      localJSONObject.put("width", this.this$1.val$adPosInfo.mAdRealWidth);
      localJSONObject.put("height", this.this$1.val$adPosInfo.mAdRealHeight);
      BannerAdPlugin.access$600(this.this$1.this$0, this.this$1.val$req, localJSONObject, "onBannerAdStateChange");
      BannerAdPlugin.access$702(this.this$1.this$0, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("BannerAdPlugin", "informJs success", localJSONException);
    }
  }
  
  public void onNoAD(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNoAD, errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    QMLog.i("BannerAdPlugin", localStringBuilder.toString());
    BannerAdPlugin.access$300(this.this$1.this$0, this.this$1.val$req, paramInt, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */