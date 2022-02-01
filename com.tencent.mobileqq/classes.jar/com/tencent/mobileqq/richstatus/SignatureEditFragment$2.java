package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SignatureEditFragment$2
  implements DialogInterface.OnClickListener
{
  SignatureEditFragment$2(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.locationText = "";
    this.a.a(0, 0, 0, 0, null, 1);
    SignatureEditFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.2
 * JD-Core Version:    0.7.0.1
 */