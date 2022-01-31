package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.qphone.base.util.QLog;

class MiniGameAuthorizeManager$2
  implements DialogInterface.OnDismissListener
{
  MiniGameAuthorizeManager$2(MiniGameAuthorizeManager paramMiniGameAuthorizeManager, String paramString1, String paramString2, MiniGameAuthorizeManager.AuthorizeCallback paramAuthorizeCallback) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (AuthDialog)paramDialogInterface;
    boolean bool1 = paramDialogInterface.isConfirm();
    boolean bool2 = paramDialogInterface.isRefuse();
    paramDialogInterface = MiniGameAuthorizeManager.access$100(this.this$0, this.val$appid);
    if (paramDialogInterface != null)
    {
      if (!bool1) {
        break label75;
      }
      paramDialogInterface.setAuthorize(this.val$scopeName, true);
    }
    for (;;)
    {
      MiniGameAuthorizeManager.access$202(this.this$0, null);
      if (this.val$callback != null)
      {
        if (!bool1) {
          break;
        }
        this.val$callback.onAuthorizeFinish(true);
      }
      return;
      label75:
      if (bool2) {
        paramDialogInterface.setAuthorize(this.val$scopeName, false);
      }
    }
    if (bool2)
    {
      this.val$callback.onAuthorizeFinish(false);
      return;
    }
    QLog.d("MiniGameAuthorizeManager", 2, "showDialog, onDismiss: just dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager.2
 * JD-Core Version:    0.7.0.1
 */