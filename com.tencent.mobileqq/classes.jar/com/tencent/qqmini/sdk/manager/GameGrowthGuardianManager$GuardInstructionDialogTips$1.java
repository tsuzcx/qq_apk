package com.tencent.qqmini.sdk.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameGrowthGuardianManager$GuardInstructionDialogTips$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogTips$1(GameGrowthGuardianManager.GuardInstructionDialogTips paramGuardInstructionDialogTips) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.performReport("click");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogTips.1
 * JD-Core Version:    0.7.0.1
 */