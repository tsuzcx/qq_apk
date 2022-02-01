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
      this.jdField_a_of_type_ComTencentOpenSdkCheckerBaseAccountChecker$DefaultAccountNotify$DialogBtnClickListener.a();
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentOpenSdkCheckerBaseAccountChecker$DefaultAccountNotify$DialogBtnClickListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.sdk.checker.BaseAccountChecker.DefaultAccountNotify.1
 * JD-Core Version:    0.7.0.1
 */