package com.tencent.mobileqq.onlinestatus.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.qphone.base.util.QLog;

class AccountOnlineStateRepository$5
  extends OnBatteryChangeObserver
{
  AccountOnlineStateRepository$5(AccountOnlineStateRepository paramAccountOnlineStateRepository) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateRepository", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    AccountOnlineStateRepository.a(this.a).d().setValue(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository.5
 * JD-Core Version:    0.7.0.1
 */