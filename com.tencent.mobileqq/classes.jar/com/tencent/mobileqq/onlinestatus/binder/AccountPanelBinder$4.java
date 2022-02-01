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
    if (paramSubAccountMsg.c)
    {
      this.a.c(paramSubAccountMsg.b);
      return;
    }
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.4
 * JD-Core Version:    0.7.0.1
 */