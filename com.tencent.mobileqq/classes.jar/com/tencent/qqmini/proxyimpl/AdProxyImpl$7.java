package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class AdProxyImpl$7
  implements Runnable
{
  AdProxyImpl$7(String paramString) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.connect();
      int i = localHttpURLConnection.getResponseCode();
      QLog.i("AdProxyImpl", 1, "reportBannerAd/BlockAd rspCode" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AdProxyImpl", 1, "reportBannerAd/BlockAd error, url = " + this.a, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */