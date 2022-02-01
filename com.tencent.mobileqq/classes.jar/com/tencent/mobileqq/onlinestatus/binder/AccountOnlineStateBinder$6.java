package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusResult;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;

class AccountOnlineStateBinder$6
  implements Observer<OnlineStatusResult>
{
  AccountOnlineStateBinder$6(AccountOnlineStateBinder paramAccountOnlineStateBinder, AccountOnlineStateViewModel paramAccountOnlineStateViewModel) {}
  
  public void a(OnlineStatusResult paramOnlineStatusResult)
  {
    if (paramOnlineStatusResult.c)
    {
      paramOnlineStatusResult = AccountOnlineStateBinder.d(this.b).c();
      this.a.a(paramOnlineStatusResult);
      return;
    }
    if (AccountOnlineStateBinder.f(this.b) != null) {
      AccountOnlineStateBinder.f(this.b).a(paramOnlineStatusResult.a, paramOnlineStatusResult.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.6
 * JD-Core Version:    0.7.0.1
 */