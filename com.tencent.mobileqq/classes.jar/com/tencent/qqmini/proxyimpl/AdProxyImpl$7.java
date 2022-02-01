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
      Object localObject = (HttpURLConnection)new URL(this.a).openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setInstanceFollowRedirects(true);
      ((HttpURLConnection)localObject).connect();
      int i = ((HttpURLConnection)localObject).getResponseCode();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportBannerAd/BlockAd rspCode");
      ((StringBuilder)localObject).append(i);
      QLog.i("AdProxyImpl", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportBannerAd/BlockAd error, url = ");
      localStringBuilder.append(this.a);
      QLog.i("AdProxyImpl", 1, localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */