package com.tencent.mobileqq.writetogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class WriteTogetherUtils$2
  implements DialogInterface.OnClickListener
{
  WriteTogetherUtils$2(QQCustomDialog paramQQCustomDialog, WriteTogetherUtils.OnDialogConfirmButtonClickListener paramOnDialogConfirmButtonClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    paramDialogInterface = this.b;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.WriteTogetherUtils.2
 * JD-Core Version:    0.7.0.1
 */