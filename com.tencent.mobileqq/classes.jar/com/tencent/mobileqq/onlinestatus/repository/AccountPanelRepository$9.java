package com.tencent.mobileqq.onlinestatus.repository;

import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountBindObserverInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AccountPanelRepository$9
  implements ISubAccountApi.SubAccountBindObserverInterface
{
  AccountPanelRepository$9(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramBoolean1) && (localAppRuntime != null) && (!paramBoolean2))
    {
      AccountPanelRepository.a(this.a).o();
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, String.format("onGetBindSubAccount, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
      }
      return;
    }
    QLog.d("AccountPanelRepository", 1, String.format("onGetBindSubAccount return, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramBoolean1) && (localAppRuntime != null) && (!paramBoolean2))
    {
      AccountPanelRepository.a(this.a).o();
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, String.format("onBindSubAccount, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
      }
      return;
    }
    QLog.d("AccountPanelRepository", 1, String.format("onBindSubAccount return, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramBoolean1) && (localAppRuntime != null) && (!paramBoolean2))
    {
      AccountPanelRepository.a(this.a).o();
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, String.format("onUnBindSubAccount, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
      }
      return;
    }
    QLog.d("AccountPanelRepository", 1, String.format("onUnBindSubAccount return, isSuccess: %s", new Object[] { Boolean.valueOf(paramBoolean1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.9
 * JD-Core Version:    0.7.0.1
 */