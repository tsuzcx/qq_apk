package com.tencent.mobileqq.onlinestatus.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusResult;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class AccountOnlineStateRepository$2
  extends AccountObserver
{
  AccountOnlineStateRepository$2(AccountOnlineStateRepository paramAccountOnlineStateRepository) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (QLog.isColorLevel())
    {
      paramStatus = new StringBuilder();
      paramStatus.append("onOnlineStatusChanged, isSuccess: ");
      paramStatus.append(paramBoolean1);
      paramStatus.append(" , mIsUpdateStatus: ");
      paramStatus.append(AccountOnlineStateRepository.a(this.a).a());
      paramStatus.append(", isUserSet: ");
      paramStatus.append(paramBoolean2);
      QLog.d("AccountOnlineStateRepository", 2, paramStatus.toString());
    }
    if (AccountOnlineStateRepository.a(this.a).a())
    {
      AccountOnlineStateRepository.a(this.a).a(false);
      if (paramBoolean1)
      {
        AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(true, 0));
        return;
      }
      AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(false, -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository.2
 * JD-Core Version:    0.7.0.1
 */