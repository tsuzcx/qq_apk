package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameGrowthGuardianManager$GuardInstructionDialogLogout
  extends GameGrowthGuardianManager.GuardInstructionDialog
{
  GameGrowthGuardianManager$GuardInstructionDialogLogout(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppInfo);
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_msg_unsupport_i_know, new GameGrowthGuardianManager.GuardInstructionDialogLogout.1(this));
  }
  
  protected String getReportSubActionType()
  {
    return "loginout";
  }
  
  protected void onShowForReport(DialogInterface paramDialogInterface)
  {
    performReport("expo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout
 * JD-Core Version:    0.7.0.1
 */