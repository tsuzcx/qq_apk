package com.tencent.mobileqq.onlinestatus.repository;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class AccountPanelRepository$6
  implements Observer
{
  AccountPanelRepository$6(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (MobileQQ.sMobileQQ.peekAppRuntime() == null)
    {
      QLog.d("AccountPanelRepository", 1, String.format("mObserver update return", new Object[0]));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelRepository", 2, "update");
    }
    if ((paramObject instanceof String[]))
    {
      paramObservable = (String[])paramObject;
      if ((paramObservable.length == 2) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObservable[0])))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanelRepository", 2, "update() -> before update");
        }
        ThreadManager.getUIHandler().post(new AccountPanelRepository.6.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.6
 * JD-Core Version:    0.7.0.1
 */