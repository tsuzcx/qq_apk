package com.tencent.mobileqq.onlinestatus.binder;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer;
import com.tencent.qphone.base.util.QLog;

class AccountPanelBinder$11
  implements Observer<Boolean>
{
  AccountPanelBinder$11(AccountPanelBinder paramAccountPanelBinder, AccountPanel paramAccountPanel, AccountPanelViewContainer paramAccountPanelViewContainer) {}
  
  public void a(Boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindSetOlympicStatusFlag onChanged called ");
      localStringBuilder.append(paramBoolean);
      QLog.i("AccountPanelBinder", 2, localStringBuilder.toString());
    }
    if (paramBoolean.booleanValue()) {
      this.c.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountPanelBinder.11
 * JD-Core Version:    0.7.0.1
 */