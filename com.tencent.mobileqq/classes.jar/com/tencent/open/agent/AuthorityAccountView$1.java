package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthorityAccountView$1
  implements View.OnClickListener
{
  AuthorityAccountView$1(AuthorityAccountView paramAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    if (AuthorityAccountView.a(this.a) != null) {
      AuthorityAccountView.a(this.a).a();
    }
    if (!this.a.q)
    {
      this.a.i();
      this.a.q = true;
    }
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.1
 * JD-Core Version:    0.7.0.1
 */