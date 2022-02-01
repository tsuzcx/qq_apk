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
    this.a.a(false);
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.4
 * JD-Core Version:    0.7.0.1
 */