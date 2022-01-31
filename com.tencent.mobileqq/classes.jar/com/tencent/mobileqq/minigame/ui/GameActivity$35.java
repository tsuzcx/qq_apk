package com.tencent.mobileqq.minigame.ui;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

class GameActivity$35
  implements Runnable
{
  GameActivity$35(GameActivity paramGameActivity, String paramString) {}
  
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
      QLog.i("[minigame] GameActivity", 1, "reportBannerAd rspCode" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("[minigame] GameActivity", 1, "reportBannerAd error, url = " + this.val$reportUrl, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.35
 * JD-Core Version:    0.7.0.1
 */