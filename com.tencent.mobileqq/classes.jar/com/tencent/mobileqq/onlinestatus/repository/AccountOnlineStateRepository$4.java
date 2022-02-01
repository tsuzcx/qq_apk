package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusResult;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.qphone.base.util.QLog;

class AccountOnlineStateRepository$4
  extends OnlineStatusObserver
{
  AccountOnlineStateRepository$4(AccountOnlineStateRepository paramAccountOnlineStateRepository) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateRepository", 2, new Object[] { "onSetOnlineStatus, isSuccess: ", Boolean.valueOf(paramBoolean), " , mIsUpdateStatus: ", Boolean.valueOf(AccountOnlineStateRepository.a(this.a).a()) });
    }
    if (AccountOnlineStateRepository.a(this.a).a())
    {
      AccountOnlineStateRepository.a(this.a).a(false);
      if (paramBoolean)
      {
        AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(true, 0));
        return;
      }
      AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(false, -1));
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    int i = paramBundle.getInt("StatusId");
    if (!paramBoolean) {
      AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(false, -1));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateRepository", 2, new Object[] { "onSetExtInfo: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean), " statusId", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository.4
 * JD-Core Version:    0.7.0.1
 */