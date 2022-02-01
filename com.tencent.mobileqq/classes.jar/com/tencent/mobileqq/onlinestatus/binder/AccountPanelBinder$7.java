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
    this.a.a(paramOnlineStatusData.a, paramOnlineStatusData.b);
    this.b.a(paramOnlineStatusData.a, paramOnlineStatusData.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.7
 * JD-Core Version:    0.7.0.1
 */