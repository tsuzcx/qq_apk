package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameGrowthGuardianManager$GuardInstructionDialogOpenUrl
  extends GameGrowthGuardianManager.GuardInstructionDialog
{
  GameGrowthGuardianManager$GuardInstructionDialogOpenUrl(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppInfo);
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_cancel, new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.2(this));
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(R.string.mini_sdk_lite_open, new GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogOpenUrl
 * JD-Core Version:    0.7.0.1
 */