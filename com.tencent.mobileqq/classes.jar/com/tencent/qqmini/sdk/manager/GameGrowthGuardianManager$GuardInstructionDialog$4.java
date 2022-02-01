package com.tencent.qqmini.sdk.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class GameGrowthGuardianManager$GuardInstructionDialog$4
  implements DialogInterface.OnDismissListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$4(GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.this$0.onDismissForReport(paramDialogInterface);
    GameGrowthGuardianManager.unregisterActivityOnStopCallback();
    if (GameGrowthGuardianManager.GuardInstructionDialog.access$700(this.this$0) != null) {
      GameGrowthGuardianManager.GuardInstructionDialog.access$700(this.this$0).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.4
 * JD-Core Version:    0.7.0.1
 */