package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;

class AccountOnlineStateBinder$7
  implements Observer<OnlineStatusPermissionChecker.OnlineStatusPermissionItem>
{
  AccountOnlineStateBinder$7(AccountOnlineStateBinder paramAccountOnlineStateBinder) {}
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    paramOnlineStatusPermissionItem = (OnlineStatusData)AccountOnlineStateBinder.a(this.a).a().getValue();
    AccountOnlineStateBinder.a(this.a, paramOnlineStatusPermissionItem.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.7
 * JD-Core Version:    0.7.0.1
 */