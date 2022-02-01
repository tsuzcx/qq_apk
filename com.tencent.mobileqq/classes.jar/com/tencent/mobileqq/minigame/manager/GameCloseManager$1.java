package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class GameCloseManager$1
  implements View.OnClickListener
{
  GameCloseManager$1(MiniAppInfo paramMiniAppInfo, QQCustomDialog paramQQCustomDialog, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity, MiniAppConfig paramMiniAppConfig) {}
  
  public void onClick(View paramView)
  {
    GameCloseManager.access$100(this.val$appInfo, null, this.val$qqCustomDialog, 0, this.val$closeListener, this.val$gameActivity, true);
    MiniProgramLpReportDC04239.reportAsync(this.val$closeAppConfig, "minigame_popup", "icon", "click", this.val$appInfo.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.1
 * JD-Core Version:    0.7.0.1
 */