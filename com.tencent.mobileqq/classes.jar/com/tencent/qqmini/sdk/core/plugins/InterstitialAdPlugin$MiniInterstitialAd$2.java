package com.tencent.qqmini.sdk.core.plugins;

import bglu;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class InterstitialAdPlugin$MiniInterstitialAd$2
  implements AdProxy.InterstitialADLisener
{
  InterstitialAdPlugin$MiniInterstitialAd$2(InterstitialAdPlugin.MiniInterstitialAd paramMiniInterstitialAd, int paramInt1, int paramInt2) {}
  
  public void onDismiss()
  {
    QMLog.i("SDK_MiniInterstitialAd", "onDismiss");
    if (InterstitialAdPlugin.MiniInterstitialAd.access$500(this.this$1) != null)
    {
      JSONObject localJSONObject = InterstitialAdPlugin.MiniInterstitialAd.access$600(this.this$1, this.val$compId, -1);
      InterstitialAdPlugin.MiniInterstitialAd.access$500(this.this$1).a("onInterstitialAdClose", localJSONObject.toString(), 0);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    QMLog.i("SDK_MiniInterstitialAd", "onError, errCode = " + paramInt + ", errMsg = " + paramString);
    InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, true, "operateInterstitialAd", this.val$compId, paramInt, this.val$callbackId);
    InterstitialAdPlugin.MiniInterstitialAd.access$402(this.this$1, false);
  }
  
  public void onLoad()
  {
    QMLog.i("SDK_MiniInterstitialAd", "onLoad");
    InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$1, true, "operateInterstitialAd", this.val$compId, 0, this.val$callbackId);
    InterstitialAdPlugin.MiniInterstitialAd.access$402(this.this$1, false);
  }
  
  public void onShow()
  {
    QMLog.i("SDK_MiniInterstitialAd", "onShow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InterstitialAdPlugin.MiniInterstitialAd.2
 * JD-Core Version:    0.7.0.1
 */