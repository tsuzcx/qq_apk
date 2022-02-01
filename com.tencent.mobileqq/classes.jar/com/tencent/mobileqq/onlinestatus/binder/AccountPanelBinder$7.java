package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;

class AccountPanelBinder$7
  implements Observer<OnlineStatusData>
{
  AccountPanelBinder$7(AccountPanelBinder paramAccountPanelBinder, AccountPanelViewContainer paramAccountPanelViewContainer, AccountPanel paramAccountPanel) {}
  
  public void a(OnlineStatusData paramOnlineStatusData)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelViewContainer.a(paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.a(paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.7
 * JD-Core Version:    0.7.0.1
 */