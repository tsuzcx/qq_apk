package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate$1(GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate paramGuardInstructionDialogRealNameAuthenticate) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.1
 * JD-Core Version:    0.7.0.1
 */