package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate
  extends GameGrowthGuardianManager.GuardInstructionDialog
{
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppConfig);
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    QLog.d("GameGrowthGuardianManag", 1, "getNegativeDialogAction() called non skipped");
    return new GameGrowthGuardianManager.DialogAction(2131705503, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1(this));
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(2131697525, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2(this));
  }
  
  protected String getReportSubActionType()
  {
    return "off_idAlert";
  }
  
  protected void onShowForReport(DialogInterface paramDialogInterface)
  {
    performReport("expo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
 * JD-Core Version:    0.7.0.1
 */