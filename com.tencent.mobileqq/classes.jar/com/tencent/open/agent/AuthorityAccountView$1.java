package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class AuthorityAccountView$1
  implements View.OnClickListener
{
  AuthorityAccountView$1(AuthorityAccountView paramAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    if (AuthorityAccountView.a(this.a) != null) {
      AuthorityAccountView.a(this.a).a();
    }
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.f();
      this.a.jdField_a_of_type_Boolean = true;
    }
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.1
 * JD-Core Version:    0.7.0.1
 */