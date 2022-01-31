package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class InterstitialAdPlugin$MiniInterstitialAd$1$1
  implements MiniAppController.ActivityResultListener
{
  InterstitialAdPlugin$MiniInterstitialAd$1$1(InterstitialAdPlugin.MiniInterstitialAd.1 param1) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt1 == 10001)
    {
      if (InterstitialAdPlugin.MiniInterstitialAd.access$300(this.this$1.this$0) != null)
      {
        paramIntent = InterstitialAdPlugin.MiniInterstitialAd.access$400(this.this$1.this$0, this.this$1.val$compId, -1);
        InterstitialAdPlugin.MiniInterstitialAd.access$300(this.this$1.this$0).evaluateSubcribeJS("onInterstitialAdClose", paramIntent.toString(), 0);
      }
      AdFrequencyLimit.setInterstitialAdShowing(false);
      if (paramInt2 != -1) {
        break label96;
      }
    }
    label96:
    for (paramIntent = "on closed";; paramIntent = "on closed error")
    {
      QLog.i("[minigame] MiniInterstitialAd", 1, paramIntent);
      MiniAppController.getInstance().removeActivityResultListener(this);
      bool = true;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InterstitialAdPlugin.MiniInterstitialAd.1.1
 * JD-Core Version:    0.7.0.1
 */