package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate$2
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate$2(GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate paramGuardInstructionDialogRealNameAuthenticate) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((this.this$0.getContext() instanceof Activity)) && (this.this$0.getGuardInstruction() != null))
    {
      paramDialogInterface = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      Activity localActivity = (Activity)this.this$0.getContext();
      Intent localIntent = new Intent();
      localIntent.putExtra("url", this.this$0.getGuardInstruction().url.get());
      paramDialogInterface.startBrowserActivity(localActivity, localIntent);
    }
    this.this$0.performReport("identi_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2
 * JD-Core Version:    0.7.0.1
 */