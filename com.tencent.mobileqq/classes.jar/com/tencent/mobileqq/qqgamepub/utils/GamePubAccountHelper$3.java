package com.tencent.mobileqq.qqgamepub.utils;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class GamePubAccountHelper$3
  implements Runnable
{
  GamePubAccountHelper$3(String paramString) {}
  
  public void run()
  {
    try
    {
      localObject = (HttpURLConnection)new URL(this.a).openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setInstanceFollowRedirects(true);
      ((HttpURLConnection)localObject).connect();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportExposureByHttp rspCode=");
      localStringBuilder.append(((HttpURLConnection)localObject).getResponseCode());
      QLog.i("QQGamePub_GamePubAccountHelper", 1, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label87:
      break label87;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportExposureByHttp error, url = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("QQGamePub_GamePubAccountHelper", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper.3
 * JD-Core Version:    0.7.0.1
 */