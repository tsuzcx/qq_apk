package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.model.SubAccountMsg;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;

class AccountPanelBinder$4
  implements Observer<SubAccountMsg>
{
  AccountPanelBinder$4(AccountPanelBinder paramAccountPanelBinder, AccountPanelViewContainer paramAccountPanelViewContainer) {}
  
  public void a(SubAccountMsg paramSubAccountMsg)
  {
    if (paramSubAccountMsg.b)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.c(paramSubAccountMsg.a);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.4
 * JD-Core Version:    0.7.0.1
 */