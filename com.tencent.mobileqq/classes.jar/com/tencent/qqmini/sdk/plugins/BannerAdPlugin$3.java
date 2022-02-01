package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class BannerAdPlugin$3
  implements Runnable
{
  BannerAdPlugin$3(BannerAdPlugin paramBannerAdPlugin) {}
  
  public void run()
  {
    boolean bool = this.this$0.hideBannerAd();
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideBannerAd ");
      localStringBuilder.append(bool);
      QMLog.i("BannerAdPlugin", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.3
 * JD-Core Version:    0.7.0.1
 */