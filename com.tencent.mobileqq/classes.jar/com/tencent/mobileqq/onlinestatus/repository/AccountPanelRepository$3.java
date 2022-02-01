package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import mqq.app.MobileQQ;

class AccountPanelRepository$3
  extends WeatherObserver
{
  AccountPanelRepository$3(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    AccountPanelRepository.a(this.a).a(paramBoolean, paramBundle, localAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.3
 * JD-Core Version:    0.7.0.1
 */