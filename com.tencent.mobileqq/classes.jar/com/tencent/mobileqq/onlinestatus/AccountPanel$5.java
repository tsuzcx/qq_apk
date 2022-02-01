package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$5
  implements DialogInterface.OnClickListener
{
  AccountPanel$5(AccountPanel paramAccountPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((AccountPanel.a(this.a) != null) && (AccountPanel.a(this.a).isShowing()))
      {
        this.a.c();
        AccountPanel.a(this.a).dismiss();
        AccountPanel.a(this.a, null);
      }
      label49:
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "switch status cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.5
 * JD-Core Version:    0.7.0.1
 */