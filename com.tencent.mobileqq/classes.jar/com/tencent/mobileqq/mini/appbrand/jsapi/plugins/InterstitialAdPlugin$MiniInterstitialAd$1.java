package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import yuk;

class InterstitialAdPlugin$MiniInterstitialAd$1
  implements Runnable
{
  InterstitialAdPlugin$MiniInterstitialAd$1(InterstitialAdPlugin.MiniInterstitialAd paramMiniInterstitialAd, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (InterstitialAdPlugin.MiniInterstitialAd.access$100(this.this$0).a(InterstitialAdPlugin.MiniInterstitialAd.access$000(this.this$0).activityContext))
      {
        InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, true, "operateInterstitialAd", this.val$compId, 0, this.val$callbackId);
        AdFrequencyLimit.setInterstitialAdShowing(true);
        MiniAppController.getInstance().setActivityResultListener(new InterstitialAdPlugin.MiniInterstitialAd.1.1(this));
        return;
      }
      QLog.e("[minigame] MiniInterstitialAd", 1, "adInterstitial show false");
      InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, 1003, this.val$callbackId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[minigame] MiniInterstitialAd", 1, "adInterstitial show Exception:", localThrowable);
      InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, 1003, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InterstitialAdPlugin.MiniInterstitialAd.1
 * JD-Core Version:    0.7.0.1
 */