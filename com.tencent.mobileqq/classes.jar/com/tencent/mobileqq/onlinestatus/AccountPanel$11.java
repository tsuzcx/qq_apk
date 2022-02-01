package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

class AccountPanel$11
  extends SubAccountBindObserver
{
  AccountPanel$11(AccountPanel paramAccountPanel) {}
  
  public void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((!paramBoolean) || (AccountPanel.a(this.a) == null) || (AccountPanel.a(this.a).isFinishing()) || (AccountPanel.a(this.a) == null) || (paramSubAccountBackProtocData == null)) {
      QLog.d("AccountPanel", 1, String.format("onGetBindSubAccount return, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    do
    {
      return;
      AccountPanel.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onGetBindSubAccount, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((!paramBoolean) || (AccountPanel.a(this.a) == null) || (AccountPanel.a(this.a).isFinishing()) || (AccountPanel.a(this.a) == null) || (paramSubAccountBackProtocData == null)) {
      QLog.d("AccountPanel", 1, String.format("onBindSubAccount return, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    do
    {
      return;
      AccountPanel.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onBindSubAccount, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((!paramBoolean) || (AccountPanel.a(this.a) == null) || (AccountPanel.a(this.a).isFinishing()) || (AccountPanel.a(this.a) == null) || (paramSubAccountBackProtocData == null)) {
      QLog.d("AccountPanel", 1, String.format("onUnBindSubAccount return, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    do
    {
      return;
      AccountPanel.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUnBindSubAccount, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.11
 * JD-Core Version:    0.7.0.1
 */