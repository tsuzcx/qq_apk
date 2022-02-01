package com.tencent.qqmini.sdk.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

class GameGrowthGuardianManager$GuardInstructionDialogOpenUrl$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogOpenUrl$1(GameGrowthGuardianManager.GuardInstructionDialogOpenUrl paramGuardInstructionDialogOpenUrl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if ((this.this$0.getContext() instanceof Activity))
    {
      paramDialogInterface = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      Activity localActivity = (Activity)this.this$0.getContext();
      Intent localIntent = new Intent();
      localIntent.putExtra("url", this.this$0.getGuardInstruction().url.get());
      paramDialogInterface.startBrowserActivity(localActivity, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogOpenUrl.1
 * JD-Core Version:    0.7.0.1
 */