package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ForwardSdkBaseOption$4
  implements DialogInterface.OnClickListener
{
  ForwardSdkBaseOption$4(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b(false);
    com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
    this.a.s.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.4
 * JD-Core Version:    0.7.0.1
 */