package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class Monitor$1
  implements Runnable
{
  Monitor$1(String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = (HttpURLConnection)new URL(this.a).openConnection();
      if (localObject != null)
      {
        ((HttpURLConnection)localObject).setConnectTimeout(8000);
        ((HttpURLConnection)localObject).setReadTimeout(10000);
        ((HttpURLConnection)localObject).setDoOutput(true);
        ((HttpURLConnection)localObject).setRequestMethod("POST");
        ((HttpURLConnection)localObject).setRequestProperty("Accept-Charset", "utf-8");
        ((HttpURLConnection)localObject).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        if (((HttpURLConnection)localObject).getResponseCode() == 200)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" report to monitor success,URL = ");
            ((StringBuilder)localObject).append(this.a);
            QLog.i("Monitor", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" report to monitor failed,URL = ");
          ((StringBuilder)localObject).append(this.a);
          QLog.i("Monitor", 2, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.Monitor.1
 * JD-Core Version:    0.7.0.1
 */