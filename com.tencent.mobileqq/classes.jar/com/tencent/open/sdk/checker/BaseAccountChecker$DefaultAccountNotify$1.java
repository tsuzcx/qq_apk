package com.tencent.open.sdk.checker;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseAccountChecker$DefaultAccountNotify$1
  implements DialogInterface.OnClickListener
{
  BaseAccountChecker$DefaultAccountNotify$1(BaseAccountChecker.DefaultAccountNotify paramDefaultAccountNotify, BaseAccountChecker.DefaultAccountNotify.DialogBtnClickListener paramDialogBtnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a();
      return;
    }
    if (paramInt == 0) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.sdk.checker.BaseAccountChecker.DefaultAccountNotify.1
 * JD-Core Version:    0.7.0.1
 */