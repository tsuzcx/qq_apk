package com.tencent.mobileqq.onlinestatus.viewmodel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;

class AccountPanelViewModel$2
  implements Runnable
{
  AccountPanelViewModel$2(AccountPanelViewModel paramAccountPanelViewModel, QBaseActivity paramQBaseActivity, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b != null))
    {
      AccountPanelViewModel.a(this.this$0, true);
      AccountPanelViewModel.b(this.this$0, false);
      Object localObject = this.this$0;
      AccountPanelViewModel.a((AccountPanelViewModel)localObject, AccountPanelViewModel.a((AccountPanelViewModel)localObject, this.b));
      localObject = (ISubAccountApi)QRoute.api(ISubAccountApi.class);
      ((ISubAccountApi)localObject).startAllSubMessageAccountMsg(false);
      ((ISubAccountApi)localObject).startGetThirdQQUnreadNum(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel.2
 * JD-Core Version:    0.7.0.1
 */