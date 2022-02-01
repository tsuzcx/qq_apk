package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class SignatureEditFragment$4
  implements DialogInterface.OnClickListener
{
  SignatureEditFragment$4(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    VasWebviewUtil.a("signature_update", "click_choose", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.4
 * JD-Core Version:    0.7.0.1
 */