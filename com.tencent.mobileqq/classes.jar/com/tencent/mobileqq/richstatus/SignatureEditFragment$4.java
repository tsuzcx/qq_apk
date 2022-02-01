package com.tencent.mobileqq.richstatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class SignatureEditFragment$4
  implements DialogInterface.OnClickListener
{
  SignatureEditFragment$4(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().finish();
    VasWebviewUtil.reportCommercialDrainage("signature_update", "click_close", "click_close", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.4
 * JD-Core Version:    0.7.0.1
 */