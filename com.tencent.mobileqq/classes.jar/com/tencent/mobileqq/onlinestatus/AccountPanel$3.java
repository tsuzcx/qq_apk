package com.tencent.mobileqq.onlinestatus;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class AccountPanel$3
  implements DialogInterface.OnClickListener
{
  AccountPanel$3(AccountPanel paramAccountPanel, AppRuntime.Status paramStatus, long paramLong, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(AccountPanel.a(this.d)))
    {
      AccountPanel.d(this.d).i().setValue(Boolean.valueOf(true));
      QQToast.makeText(AccountPanel.a(this.d), 1, 2131916775, 1).show();
      return;
    }
    AccountPanel.d(this.d).a(this.a, this.b, true);
    if (AccountPanel.e(this.d) != null) {
      AccountPanel.e(this.d).a(this.c);
    }
    ReportController.b(AccountPanel.c(this.d), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.3
 * JD-Core Version:    0.7.0.1
 */