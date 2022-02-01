package com.tencent.mobileqq.onlinestatus.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.SubAccountInfoProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountPanelViewContainer$2
  implements View.OnClickListener
{
  AccountPanelViewContainer$2(AccountPanelViewContainer paramAccountPanelViewContainer) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof AccountPanelViewContainer.AccountItemViewHolder)) && (!((IPwdSetUtilApi)QRoute.api(IPwdSetUtilApi.class)).checkHasNotSetPwd(AccountPanelViewContainer.a(this.a))))
    {
      int i = ((AccountPanelViewContainer.AccountItemViewHolder)paramView.getTag()).g;
      Object localObject;
      if (i != 1)
      {
        if (i == 2)
        {
          localObject = (ISubAccountApi.SubAccountInfoProxy)paramView.getTag(AccountPanelViewContainer.b);
          AccountPanelViewContainer.b(this.a).a((ISubAccountApi.SubAccountInfoProxy)localObject);
        }
      }
      else
      {
        localObject = (SimpleAccount)paramView.getTag(AccountPanelViewContainer.b);
        AccountPanelViewContainer.b(this.a).a((SimpleAccount)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AccountPanelViewContainer.2
 * JD-Core Version:    0.7.0.1
 */