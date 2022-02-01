package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class SignatureEditFragment$3
  implements DialogInterface.OnClickListener
{
  SignatureEditFragment$3(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    VasWebviewUtil.reportCommercialDrainage("signature_update", "click_choose", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.3
 * JD-Core Version:    0.7.0.1
 */