package com.tencent.qqmini.sdk.core.plugins;

import betc;

class BannerAdPlugin$3
  implements Runnable
{
  BannerAdPlugin$3(BannerAdPlugin paramBannerAdPlugin) {}
  
  public void run()
  {
    boolean bool = this.this$0.hideBannerAd();
    if (betc.a()) {
      betc.b("BannerAdPlugin", "hideBannerAd " + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */