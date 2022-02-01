package com.tencent.mobileqq.qqgamepub.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

final class GamePubAccountHelper$4
  implements Runnable
{
  GamePubAccountHelper$4(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      localObject = (HttpURLConnection)new URL(this.a).openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      ((HttpURLConnection)localObject).setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setInstanceFollowRedirects(true);
      ((HttpURLConnection)localObject).connect();
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(((HttpURLConnection)localObject).getOutputStream(), "UTF-8"));
      localBufferedWriter.write(this.b);
      localBufferedWriter.close();
      int i = ((HttpURLConnection)localObject).getResponseCode();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportExposureByHttpPost rspCode=");
      ((StringBuilder)localObject).append(i);
      QLog.i("QQGamePub_GamePubAccountHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label135:
      break label135;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportExposureByHttpPost error, url = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("QQGamePub_GamePubAccountHelper", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.4
 * JD-Core Version:    0.7.0.1
 */