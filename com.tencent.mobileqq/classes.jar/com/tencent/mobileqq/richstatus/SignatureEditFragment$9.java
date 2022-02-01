package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;

class SignatureEditFragment$9
  implements DialogInterface.OnClickListener
{
  SignatureEditFragment$9(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SignatureManagerForTool.a().a(SignatureManagerForTool.a().b);
    this.a.getQBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.9
 * JD-Core Version:    0.7.0.1
 */