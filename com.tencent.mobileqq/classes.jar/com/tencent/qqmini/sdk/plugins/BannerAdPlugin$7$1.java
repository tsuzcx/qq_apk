package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class BannerAdPlugin$7$1
  implements Runnable
{
  BannerAdPlugin$7$1(BannerAdPlugin.7 param7) {}
  
  public void run()
  {
    if (BannerAdPlugin.access$1800(this.a.this$0))
    {
      BannerAdPlugin.access$1000(this.a.this$0);
      return;
    }
    QMLog.i("BannerAdPlugin", "refreshBannerAdView fail.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */