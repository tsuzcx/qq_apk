package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.open.agent.authority.AuthorityControlAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

class AuthorityControlFragment$7
  implements View.OnClickListener
{
  AuthorityControlFragment$7(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onClick(View paramView)
  {
    AuthorityControlFragment.d(this.a).e();
    AuthorityControlFragment localAuthorityControlFragment = this.a;
    AuthorityControlFragment.a(localAuthorityControlFragment, localAuthorityControlFragment.rightViewText, 2131887125);
    this.a.rightViewText.setTextColor(AuthorityControlFragment.j(this.a));
    this.a.rightViewText.setEnabled(true);
    this.a.setLeftButton("", null);
    this.a.leftView.setVisibility(0);
    AuthorityControlFragment.g(this.a).setText(2131887147);
    AuthorityControlFragment.i(this.a).setOverScrollHeader(AuthorityControlFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment.7
 * JD-Core Version:    0.7.0.1
 */