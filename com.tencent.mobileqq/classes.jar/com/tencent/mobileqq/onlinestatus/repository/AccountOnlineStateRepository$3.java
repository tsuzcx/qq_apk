package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusResult;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;

class AccountOnlineStateRepository$3
  extends OnlineStatusPermissionObserver
{
  AccountOnlineStateRepository$3(AccountOnlineStateRepository paramAccountOnlineStateRepository) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    if (paramBoolean)
    {
      if (!paramBundle.getBoolean("param_need_switch_online_status")) {
        AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(true, 0));
      }
    }
    else {
      AccountOnlineStateRepository.a(this.a).e().setValue(new OnlineStatusResult(true, -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository.3
 * JD-Core Version:    0.7.0.1
 */