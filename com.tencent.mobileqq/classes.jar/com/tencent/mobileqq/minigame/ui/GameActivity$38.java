package com.tencent.mobileqq.minigame.ui;

import android.os.Build;
import android.os.Build.VERSION;
import axqn;
import bbll;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

class GameActivity$38
  implements Runnable
{
  GameActivity$38(GameActivity paramGameActivity) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.getCurrentAccountUin()).append("-").append(GameActivity.access$4900(this.this$0)).append("-").append(bbll.a()).append("-").append(Build.BRAND).append("-").append(Build.MODEL).append("-").append(Build.VERSION.SDK_INT);
    Properties localProperties = new Properties();
    localProperties.put("detail_ino", localStringBuilder.toString());
    axqn.a(BaseApplicationImpl.getContext()).reportKVEvent("minigame_density_info", localProperties);
    QLog.i("[minigame] GameActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.38
 * JD-Core Version:    0.7.0.1
 */