package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.qphone.base.util.QLog;

class GameActivity$37
  implements Runnable
{
  GameActivity$37(GameActivity paramGameActivity) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("miniAppID", GameActivity.access$4800(this.this$0).appId);
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_app_client_module");
    this.this$0.onProcessForeGround(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("[minigame] GameActivity", 1, "onResume--onRefreshMiniBadge");
    }
    this.this$0.onRefreshMiniBadge(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.37
 * JD-Core Version:    0.7.0.1
 */