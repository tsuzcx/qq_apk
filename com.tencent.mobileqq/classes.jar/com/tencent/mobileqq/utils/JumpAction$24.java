package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;

class JumpAction$24
  implements DialogInterface.OnDismissListener
{
  JumpAction$24(JumpAction paramJumpAction) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a().getLoginActivityClass().isInstance(this.a.a)) {
      ((Activity)this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.24
 * JD-Core Version:    0.7.0.1
 */