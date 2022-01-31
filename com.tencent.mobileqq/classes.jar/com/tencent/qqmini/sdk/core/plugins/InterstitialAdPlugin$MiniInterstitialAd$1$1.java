package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Intent;
import bghk;
import bgjd;
import bgje;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;

class InterstitialAdPlugin$MiniInterstitialAd$1$1
  implements bgje
{
  InterstitialAdPlugin$MiniInterstitialAd$1$1(InterstitialAdPlugin.MiniInterstitialAd.1 param1) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    String str;
    if (paramInt1 == 10001)
    {
      bghk.b(false);
      if (paramInt2 != -1) {
        break label132;
      }
      str = "on closed";
      if (InterstitialAdPlugin.MiniInterstitialAd.access$300(this.this$2.this$1) != null) {
        InterstitialAdPlugin.MiniInterstitialAd.access$300(this.this$2.this$1).onDismiss();
      }
      bgjd.a().b(this);
      if (InterstitialAdPlugin.MiniInterstitialAd.access$000(this.this$2.this$1) == null) {
        break label139;
      }
    }
    label132:
    label139:
    for (Activity localActivity = (Activity)InterstitialAdPlugin.MiniInterstitialAd.access$000(this.this$2.this$1).get();; localActivity = null)
    {
      if (InterstitialAdPlugin.MiniInterstitialAd.access$100(this.this$2.this$1) != null) {
        InterstitialAdPlugin.MiniInterstitialAd.access$100(this.this$2.this$1).onClose(localActivity, paramInt2, paramIntent);
      }
      QMLog.i("SDK_MiniInterstitialAd", str);
      bool = true;
      return bool;
      str = "on closed error";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InterstitialAdPlugin.MiniInterstitialAd.1.1
 * JD-Core Version:    0.7.0.1
 */