package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class GameGrowthGuardianManager$GuardInstructionDialog$3
  implements DialogInterface.OnDismissListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$3(GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (GameGrowthGuardianManager.GuardInstructionDialog.access$200(this.this$0) != null) {
      GameGrowthGuardianManager.GuardInstructionDialog.access$200(this.this$0).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog.3
 * JD-Core Version:    0.7.0.1
 */