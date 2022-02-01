package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

final class GameCloseManager$2
  implements DialogInterface.OnClickListener
{
  GameCloseManager$2(MiniAppInfo paramMiniAppInfo, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GameCloseManager.access$000(this.val$finalMoreAppInfo, paramDialogInterface, paramInt, this.val$closeListener, this.val$gameActivity, true);
    MiniProgramLpReportDC04239.reportAsync("minigame_popup", "moregame", "click", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.2
 * JD-Core Version:    0.7.0.1
 */