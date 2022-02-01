package com.tencent.mobileqq.onlinestatus.repository;

import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.MessageObserverInterface;
import com.tencent.qphone.base.util.QLog;

class AccountPanelRepository$10
  implements ISubAccountApi.MessageObserverInterface
{
  AccountPanelRepository$10(AccountPanelRepository paramAccountPanelRepository) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    AccountPanelRepository.a(this.a).a(paramBoolean, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (AccountPanelRepository.a(this.a, paramString, paramBoolean2))
    {
      QLog.d("AccountPanelRepository", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, subAccount: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
      return;
    }
    AccountPanelRepository.a(this.a).a(paramBoolean1, paramString, true);
  }
  
  public void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (AccountPanelRepository.a(this.a, paramBoolean1, paramString, paramBoolean2)) {
      return;
    }
    AccountPanelRepository.a(this.a).a(paramBoolean1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository.10
 * JD-Core Version:    0.7.0.1
 */