package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;

class SignatureEditFragment$8
  implements DialogInterface.OnClickListener
{
  SignatureEditFragment$8(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SignatureManagerForTool.a().a(SignatureManagerForTool.a().b);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.8
 * JD-Core Version:    0.7.0.1
 */