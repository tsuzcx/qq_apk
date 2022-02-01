package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$4
  implements DialogInterface.OnClickListener
{
  AccountPanel$4(AccountPanel paramAccountPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((AccountPanel.b(this.a) != null) && (AccountPanel.b(this.a).isShowing()))
      {
        AccountPanel.d(this.a).i().setValue(Boolean.valueOf(true));
        AccountPanel.b(this.a).dismiss();
        AccountPanel.a(this.a, null);
      }
      label59:
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "switch status cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.4
 * JD-Core Version:    0.7.0.1
 */