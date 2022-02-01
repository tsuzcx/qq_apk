package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

class GameGrowthGuardianManager$GuardInstructionDialogSkippedRealNameAuthenticate
  extends GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
{
  GameGrowthGuardianManager$GuardInstructionDialogSkippedRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppConfig);
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    QLog.d("GameGrowthGuardianManag", 1, "getNegativeDialogAction() called skipped real name authentication");
    return new GameGrowthGuardianManager.DialogAction(2131694446, new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate.1(this));
  }
  
  protected String getReportSubActionType()
  {
    return "skip_idAlert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate
 * JD-Core Version:    0.7.0.1
 */