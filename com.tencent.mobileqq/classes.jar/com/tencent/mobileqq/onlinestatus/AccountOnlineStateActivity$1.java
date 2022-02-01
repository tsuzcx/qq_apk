package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountOnlineStateActivity$1
  implements View.OnClickListener
{
  AccountOnlineStateActivity$1(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(View paramView)
  {
    AccountOnlineStateActivity.a(this.a).b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.1
 * JD-Core Version:    0.7.0.1
 */