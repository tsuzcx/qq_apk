package com.tencent.mobileqq.minigame.ui;

import android.text.TextUtils;
import bjds;
import com.tencent.qphone.base.util.QLog;

class GameActivity$41
  implements Runnable
{
  GameActivity$41(GameActivity paramGameActivity, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      String str = GameActivity.access$5600(this.this$0);
      if (!TextUtils.isEmpty(str)) {}
      for (str = this.val$url + "&" + str;; str = this.val$url)
      {
        GameActivity.reportAdByHttp(str);
        bjds.a(this.this$0, this.val$url, this.val$timestamp);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("[minigame] GameActivity", 1, "reportBannerAd error, url = " + this.val$url, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.41
 * JD-Core Version:    0.7.0.1
 */