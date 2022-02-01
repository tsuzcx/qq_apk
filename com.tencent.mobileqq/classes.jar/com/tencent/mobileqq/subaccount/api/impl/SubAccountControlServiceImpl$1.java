package com.tencent.mobileqq.subaccount.api.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class SubAccountControlServiceImpl$1
  implements DialogInterface.OnCancelListener
{
  SubAccountControlServiceImpl$1(SubAccountControlServiceImpl paramSubAccountControlServiceImpl, String paramString, int paramInt) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.c.cancelHintDialog(this.a, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */