package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate
  extends GameGrowthGuardianManager.GuardInstructionDialog
{
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppInfo);
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_exit_game, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1(this));
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_qb_tenpay_tenpay_shiming_title, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
 * JD-Core Version:    0.7.0.1
 */