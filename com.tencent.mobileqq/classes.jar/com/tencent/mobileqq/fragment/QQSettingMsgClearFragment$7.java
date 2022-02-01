package com.tencent.mobileqq.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QQSettingMsgClearFragment$7
  implements DialogInterface.OnClickListener
{
  QQSettingMsgClearFragment$7(QQSettingMsgClearFragment paramQQSettingMsgClearFragment, DialogInterface.OnClickListener paramOnClickListener, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface = this.b;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      this.b.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.7
 * JD-Core Version:    0.7.0.1
 */