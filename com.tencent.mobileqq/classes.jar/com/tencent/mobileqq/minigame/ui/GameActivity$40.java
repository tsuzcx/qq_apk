package com.tencent.mobileqq.minigame.ui;

import bjvn;
import com.tencent.qphone.base.util.QLog;

class GameActivity$40
  implements Runnable
{
  GameActivity$40(GameActivity paramGameActivity, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      GameActivity.reportAdByHttp(this.val$url);
      bjvn.a(this.this$0, this.val$url, this.val$timestamp);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("[minigame] GameActivity", 1, "reportBannerAd error, url = " + this.val$url, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.40
 * JD-Core Version:    0.7.0.1
 */