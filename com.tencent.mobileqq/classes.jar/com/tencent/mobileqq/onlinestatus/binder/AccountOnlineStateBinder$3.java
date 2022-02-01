package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;

class AccountOnlineStateBinder$3
  implements Observer<OnlineStatusData>
{
  AccountOnlineStateBinder$3(AccountOnlineStateBinder paramAccountOnlineStateBinder) {}
  
  public void a(OnlineStatusData paramOnlineStatusData)
  {
    AccountOnlineStateBinder.a(this.a).a(paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.3
 * JD-Core Version:    0.7.0.1
 */