package com.tencent.mobileqq.onlinestatus.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.qphone.base.util.QLog;

class AccountPanelRepository$5
  extends OnBatteryChangeObserver
{
  AccountPanelRepository$5(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanelRepository", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    AccountPanelRepository.a(this.a).b().setValue(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.5
 * JD-Core Version:    0.7.0.1
 */