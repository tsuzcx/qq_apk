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
      this.a.m();
      return;
    }
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.1
 * JD-Core Version:    0.7.0.1
 */