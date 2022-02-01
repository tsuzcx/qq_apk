package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

final class GameCloseManager$3
  implements DialogInterface.OnClickListener
{
  GameCloseManager$3(MiniAppInfo paramMiniAppInfo, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity, MiniAppConfig paramMiniAppConfig) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GameCloseManager.access$100(this.val$finalMoreAppInfo, null, paramDialogInterface, paramInt, this.val$closeListener, this.val$gameActivity, false);
    MiniProgramLpReportDC04239.reportAsync(this.val$closeAppConfig, "minigame_popup", "cancel", "click", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.3
 * JD-Core Version:    0.7.0.1
 */