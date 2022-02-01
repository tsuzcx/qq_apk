package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.HttpURLConnection;
import java.net.URL;

class BlockAdPlugin$7
  implements Runnable
{
  BlockAdPlugin$7(BlockAdPlugin paramBlockAdPlugin, String paramString) {}
  
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
      ((StringBuilder)localObject).append("reportBlockAd rspCode");
      ((StringBuilder)localObject).append(i);
      QMLog.i("BlockAdPlugin", ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportBlockAd error, url = ");
      localStringBuilder.append(this.val$reportUrl);
      QMLog.i("BlockAdPlugin", localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.7
 * JD-Core Version:    0.7.0.1
 */