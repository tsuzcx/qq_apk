package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager.IUpdateListener;
import com.tencent.mobileqq.minigame.jsapi.plugins.UpdateManagerPlugin;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.qphone.base.util.QLog;

class GameActivity$28
  implements JsApiUpdateManager.IUpdateListener
{
  GameActivity$28(GameActivity paramGameActivity) {}
  
  public void onCheckResult(boolean paramBoolean)
  {
    QLog.i("[minigame] GameActivity", 1, "UpdateManager checkResult hasUpdate:" + paramBoolean + ", currentAppConfig:" + this.this$0.mGameAppConfig);
    UpdateManagerPlugin localUpdateManagerPlugin = (UpdateManagerPlugin)GameActivity.access$000(this.this$0).getJsPluginEngine().getPlugin(UpdateManagerPlugin.class);
    if (localUpdateManagerPlugin != null) {
      localUpdateManagerPlugin.setUpdateCheckResult(paramBoolean);
    }
  }
  
  public void onDownloadResult(boolean paramBoolean)
  {
    QLog.i("[minigame] GameActivity", 1, "UpdateManager downloadResult success:" + paramBoolean + ", currentAppConfig:" + this.this$0.mGameAppConfig);
    UpdateManagerPlugin localUpdateManagerPlugin = (UpdateManagerPlugin)GameActivity.access$000(this.this$0).getJsPluginEngine().getPlugin(UpdateManagerPlugin.class);
    if (localUpdateManagerPlugin != null) {
      localUpdateManagerPlugin.setUpdateDownloadResult(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.28
 * JD-Core Version:    0.7.0.1
 */