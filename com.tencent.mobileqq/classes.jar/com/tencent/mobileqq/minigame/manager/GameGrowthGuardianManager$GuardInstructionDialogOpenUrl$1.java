package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBStringField;

class GameGrowthGuardianManager$GuardInstructionDialogOpenUrl$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogOpenUrl$1(GameGrowthGuardianManager.GuardInstructionDialogOpenUrl paramGuardInstructionDialogOpenUrl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if ((this.this$0.getContext() instanceof Activity))
    {
      paramDialogInterface = (Activity)this.this$0.getContext();
      paramDialogInterface.startActivity(new Intent(paramDialogInterface, QQBrowserActivity.class).putExtra("url", this.this$0.getGuardInstruction().url.get()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.1
 * JD-Core Version:    0.7.0.1
 */