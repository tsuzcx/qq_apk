package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;

class AccountPanelBinder$1
  implements Observer<Boolean>
{
  AccountPanelBinder$1(AccountPanelBinder paramAccountPanelBinder, AccountPanelViewContainer paramAccountPanelViewContainer) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.i();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.1
 * JD-Core Version:    0.7.0.1
 */