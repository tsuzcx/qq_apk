package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class VideoFeedsHelper$27
  implements Runnable
{
  VideoFeedsHelper$27(String paramString) {}
  
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
        ((StringBuilder)localObject).append("asyncHttpReport reportUrl = ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(", rspCode:");
        ((StringBuilder)localObject).append(i);
        QLog.d("VideoFeedsHelper", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("asyncHttpReport error, url = ");
      localStringBuilder.append(this.a);
      QLog.i("VideoFeedsHelper", 1, localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.27
 * JD-Core Version:    0.7.0.1
 */