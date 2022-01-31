package com.tencent.mobileqq.filemanager.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class FMActivity$4
  implements Runnable
{
  FMActivity$4(FMActivity paramFMActivity) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.app.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if (localSharedPreferences.getBoolean("bShowWeixinDialog", false)) {
      return;
    }
    localSharedPreferences.edit().putBoolean("bShowWeixinDialog", true);
    this.this$0.runOnUiThread(new FMActivity.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.4
 * JD-Core Version:    0.7.0.1
 */