package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class AccountPanel$14
  implements Observer
{
  AccountPanel$14(AccountPanel paramAccountPanel) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((AccountPanel.a(this.a) == null) || (AccountPanel.a(this.a).isFinishing()) || (AccountPanel.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("mObserver update return", new Object[0]));
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "update");
        }
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObservable[0])));
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "update() -> before update");
    }
    AccountPanel.a(this.a).runOnUiThread(new AccountPanel.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.14
 * JD-Core Version:    0.7.0.1
 */