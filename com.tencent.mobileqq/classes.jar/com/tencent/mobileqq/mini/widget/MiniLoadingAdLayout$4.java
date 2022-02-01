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
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.val$reportUrl).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.connect();
      int i = localHttpURLConnection.getResponseCode();
      QLog.i("MiniLoadingAdLayout", 1, "reportToGdt LoadingAd rspCode" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("MiniLoadingAdLayout", 1, "reportToGdt LoadingAd error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.4
 * JD-Core Version:    0.7.0.1
 */