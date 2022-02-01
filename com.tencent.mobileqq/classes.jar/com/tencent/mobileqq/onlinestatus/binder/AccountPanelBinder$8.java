package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.qphone.base.remote.SimpleAccount;

class AccountPanelBinder$8
  implements Observer<SimpleAccount>
{
  AccountPanelBinder$8(AccountPanelBinder paramAccountPanelBinder, AccountPanelViewModel paramAccountPanelViewModel, QBaseActivity paramQBaseActivity) {}
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramSimpleAccount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.8
 * JD-Core Version:    0.7.0.1
 */