package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;

class SignTextEditFragment$3
  implements DialogInterface.OnClickListener
{
  SignTextEditFragment$3(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new RichStatus(null);
    paramDialogInterface.copyFrom(this.a.p);
    this.a.x.obtainMessage(6, paramDialogInterface).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.3
 * JD-Core Version:    0.7.0.1
 */