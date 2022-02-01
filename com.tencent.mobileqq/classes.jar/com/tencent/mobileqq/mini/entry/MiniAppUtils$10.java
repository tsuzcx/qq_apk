package com.tencent.mobileqq.mini.entry;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class MiniAppUtils$10
  implements Runnable
{
  MiniAppUtils$10(String paramString) {}
  
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
      QLog.i("MiniAppUtils", 1, "reportBannerAd rspCode" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("MiniAppUtils", 1, "reportBannerAd error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.10
 * JD-Core Version:    0.7.0.1
 */