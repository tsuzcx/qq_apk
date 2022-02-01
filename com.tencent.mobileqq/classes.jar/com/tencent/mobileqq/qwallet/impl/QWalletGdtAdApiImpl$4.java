package com.tencent.mobileqq.qwallet.impl;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

class QWalletGdtAdApiImpl$4
  implements Runnable
{
  QWalletGdtAdApiImpl$4(QWalletGdtAdApiImpl paramQWalletGdtAdApiImpl, String paramString) {}
  
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportUrlByHttpGet rspCode");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",reportUrl:");
        ((StringBuilder)localObject).append(this.a);
        QLog.i("QWalletGdtAdApi", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportUrlByHttpGet error, url = ");
        localStringBuilder.append(this.a);
        QLog.i("QWalletGdtAdApi", 2, localStringBuilder.toString(), localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletGdtAdApiImpl.4
 * JD-Core Version:    0.7.0.1
 */