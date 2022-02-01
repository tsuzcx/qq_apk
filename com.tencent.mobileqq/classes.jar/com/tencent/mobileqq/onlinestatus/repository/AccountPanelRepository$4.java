package com.tencent.mobileqq.onlinestatus.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

class AccountPanelRepository$4
  extends AccountObserver
{
  AccountPanelRepository$4(AccountPanelRepository paramAccountPanelRepository) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (paramBoolean1) {
      AccountPanelRepository.a(this.a).a(paramStatus);
    }
    if (!paramBoolean2) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    AccountPanelRepository.a(this.a).a(paramBoolean1, localAppInterface, paramStatus);
  }
  
  protected void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    AccountPanelRepository.a(this.a).a(paramStatus, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.4
 * JD-Core Version:    0.7.0.1
 */