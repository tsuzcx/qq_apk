package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;

class SignTextEditFragment$4
  implements DialogInterface.OnClickListener
{
  SignTextEditFragment$4(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SignTextEditFragment.a(this.a, "");
    paramDialogInterface.dismiss();
    this.a.x.obtainMessage(6, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.4
 * JD-Core Version:    0.7.0.1
 */