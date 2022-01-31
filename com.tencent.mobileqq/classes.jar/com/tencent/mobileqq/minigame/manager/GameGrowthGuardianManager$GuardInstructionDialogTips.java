package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class GameGrowthGuardianManager$GuardInstructionDialogTips
  extends GameGrowthGuardianManager.GuardInstructionDialog
{
  GameGrowthGuardianManager$GuardInstructionDialogTips(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppConfig);
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(2131694593, new GameGrowthGuardianManager.GuardInstructionDialogTips.1(this));
  }
  
  protected String getReportSubActionType()
  {
    return "timeAlert";
  }
  
  protected void onShowForReport(DialogInterface paramDialogInterface)
  {
    performReport("expo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogTips
 * JD-Core Version:    0.7.0.1
 */