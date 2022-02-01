package com.tencent.mobileqq.onlinestatus.viewmodel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import mqq.app.AppRuntime;

class AccountPanelViewModel$1
  implements Runnable
{
  AccountPanelViewModel$1(AccountPanelViewModel paramAccountPanelViewModel, AppRuntime paramAppRuntime, SimpleAccount paramSimpleAccount) {}
  
  public void run()
  {
    ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).setReaded(this.b.getUin(), 7000);
    ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanOneSubAccountMessageUnread((AppInterface)this.a, false, null, this.b.getUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.1
 * JD-Core Version:    0.7.0.1
 */