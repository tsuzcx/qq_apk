package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;

class JumpActionLegacy$23
  implements DialogInterface.OnDismissListener
{
  JumpActionLegacy$23(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.F().getLoginActivityClass().isInstance(this.a.b)) {
      ((Activity)this.a.b).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.23
 * JD-Core Version:    0.7.0.1
 */