package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;

class AccountPanelBinder$10
  implements Observer<Boolean>
{
  AccountPanelBinder$10(AccountPanelBinder paramAccountPanelBinder, AccountPanel paramAccountPanel, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanelViewModel paramAccountPanelViewModel) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBinderAccountPanelBinder.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.10
 * JD-Core Version:    0.7.0.1
 */