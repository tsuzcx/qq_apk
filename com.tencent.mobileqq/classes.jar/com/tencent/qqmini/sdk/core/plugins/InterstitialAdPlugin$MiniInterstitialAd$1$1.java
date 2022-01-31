package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import begv;
import beil;
import beim;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.InterstitialADLisener;

class InterstitialAdPlugin$MiniInterstitialAd$1$1
  implements beim
{
  InterstitialAdPlugin$MiniInterstitialAd$1$1(InterstitialAdPlugin.MiniInterstitialAd.1 param1) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt1 == 10001)
    {
      begv.b(false);
      if (paramInt2 != -1) {
        break label69;
      }
    }
    label69:
    for (paramIntent = "on closed";; paramIntent = "on closed error")
    {
      if (InterstitialAdPlugin.MiniInterstitialAd.access$300(this.this$2.this$1) != null) {
        InterstitialAdPlugin.MiniInterstitialAd.access$300(this.this$2.this$1).onDismiss();
      }
      beil.a().b(this);
      besl.b("SDK_MiniInterstitialAd", paramIntent);
      bool = true;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InterstitialAdPlugin.MiniInterstitialAd.1.1
 * JD-Core Version:    0.7.0.1
 */