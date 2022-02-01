package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class AuthorityAccountView$4
  implements View.OnClickListener
{
  AuthorityAccountView$4(AuthorityAccountView paramAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView)).a(this.jdField_a_of_type_JavaLangString, true);
    }
    for (;;)
    {
      if (AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView) != null) {
        AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView)).a(this.jdField_a_of_type_JavaLangString, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.4
 * JD-Core Version:    0.7.0.1
 */