package com.tencent.mobileqq.mini.widget;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

class MiniLoadingAdLayout$4
  implements Runnable
{
  MiniLoadingAdLayout$4(MiniLoadingAdLayout paramMiniLoadingAdLayout, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = (HttpURLConnection)new URL(this.val$reportUrl).openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setInstanceFollowRedirects(true);
      ((HttpURLConnection)localObject).connect();
      int i = ((HttpURLConnection)localObject).getResponseCode();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportToGdt LoadingAd rspCode");
      ((StringBuilder)localObject).append(i);
      QLog.i("MiniLoadingAdLayout", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportToGdt LoadingAd error, url = ");
      localStringBuilder.append(this.val$reportUrl);
      QLog.i("MiniLoadingAdLayout", 1, localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.4
 * JD-Core Version:    0.7.0.1
 */