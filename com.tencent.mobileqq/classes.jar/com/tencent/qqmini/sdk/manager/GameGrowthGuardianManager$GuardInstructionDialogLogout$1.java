package com.tencent.qqmini.sdk.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameGrowthGuardianManager$GuardInstructionDialogLogout$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogLogout$1(GameGrowthGuardianManager.GuardInstructionDialogLogout paramGuardInstructionDialogLogout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.performReport("click");
    this.this$0.dismissInner();
    this.this$0.doExit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout.1
 * JD-Core Version:    0.7.0.1
 */