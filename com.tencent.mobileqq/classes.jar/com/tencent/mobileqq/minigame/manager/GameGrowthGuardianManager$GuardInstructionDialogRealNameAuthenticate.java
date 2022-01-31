package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate
  extends GameGrowthGuardianManager.GuardInstructionDialog
{
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    super(paramGuardInstruction, paramContext, paramMiniAppConfig);
  }
  
  protected GameGrowthGuardianManager.DialogAction getNegativeDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(2131625035, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1(this));
  }
  
  protected GameGrowthGuardianManager.DialogAction getPositiveDialogAction()
  {
    return new GameGrowthGuardianManager.DialogAction(2131631637, new GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate
 * JD-Core Version:    0.7.0.1
 */