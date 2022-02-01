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
    if (paramOnlineStatusResult.b)
    {
      paramOnlineStatusResult = AccountOnlineStateBinder.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder).a();
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel.a(paramOnlineStatusResult);
      return;
    }
    if (AccountOnlineStateBinder.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder) != null) {
      AccountOnlineStateBinder.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountOnlineStateBinder).a(paramOnlineStatusResult.jdField_a_of_type_Boolean, paramOnlineStatusResult.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.6
 * JD-Core Version:    0.7.0.1
 */