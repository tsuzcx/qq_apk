package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;

class GameGrowthGuardianManager$GuardInstructionDialogLogout$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogLogout$1(GameGrowthGuardianManager.GuardInstructionDialogLogout paramGuardInstructionDialogLogout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout.1
 * JD-Core Version:    0.7.0.1
 */