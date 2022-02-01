package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameGrowthGuardianManager$GuardInstructionDialogSkippedRealNameAuthenticate
  extends GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
{
  GameGrowthGuardianManager$GuardInstructionDialogSkippedRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppInfo);
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_pretty_number_cancel, new GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate.1(this));
  }
  
  protected String getReportSubActionType()
  {
    return "skip_idAlert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogSkippedRealNameAuthenticate
 * JD-Core Version:    0.7.0.1
 */