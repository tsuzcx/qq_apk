package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

class AccountPanelRepository$1
  extends OnlineStatusObserver
{
  AccountPanelRepository$1(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i;
    if (paramBundle != null) {
      i = (int)paramBundle.getLong("onlineStatus", 0L);
    } else {
      i = 0;
    }
    AppRuntime.Status localStatus = AppRuntime.Status.build(i);
    if (paramBoolean) {
      AccountPanelRepository.a(this.a).a(localStatus);
    }
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    AccountPanelRepository.a(this.a).a(paramBoolean, paramBundle, localStatus, localAppInterface);
  }
  
  public void a(boolean paramBoolean, OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    AccountPanelRepository.a(this.a).a(paramOlympicMedalEventInfo);
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    AccountPanelRepository.a(this.a).b(paramBoolean, paramBundle);
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle)
  {
    super.c(paramBoolean, paramBundle);
    AccountPanelRepository.a(this.a).c(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.1
 * JD-Core Version:    0.7.0.1
 */