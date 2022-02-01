package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Monitor$1
  implements Runnable
{
  public Monitor$1(String paramString) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
      if (localHttpURLConnection != null)
      {
        localHttpURLConnection.setConnectTimeout(8000);
        localHttpURLConnection.setReadTimeout(10000);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        if (localHttpURLConnection.getResponseCode() == 200)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Monitor", 2, " report to monitor success,URL = " + this.a);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("Monitor", 2, " report to monitor failed,URL = " + this.a);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Monitor", 2, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.Monitor.1
 * JD-Core Version:    0.7.0.1
 */