package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginAccountFragment$1
  implements View.OnClickListener
{
  LoginAccountFragment$1(LoginAccountFragment paramLoginAccountFragment) {}
  
  public void onClick(View paramView)
  {
    LoginAccountFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LoginAccountFragment.1
 * JD-Core Version:    0.7.0.1
 */