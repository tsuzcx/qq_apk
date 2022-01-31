package com.tencent.qqmini.sdk.core.plugins;

import betc;
import java.net.HttpURLConnection;
import java.net.URL;

class BannerAdPlugin$5
  implements Runnable
{
  BannerAdPlugin$5(BannerAdPlugin paramBannerAdPlugin, String paramString) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.val$reportUrl).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.connect();
      int i = localHttpURLConnection.getResponseCode();
      betc.b("BannerAdPlugin", "reportBannerAd rspCode" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.b("BannerAdPlugin", "reportBannerAd error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BannerAdPlugin.5
 * JD-Core Version:    0.7.0.1
 */