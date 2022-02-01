package com.tencent.open.agent;

import com.tencent.mobileqq.utils.QQCustomDialog;

class AuthorityAccountView$DelAccountRunnable$1
  implements Runnable
{
  AuthorityAccountView$DelAccountRunnable$1(AuthorityAccountView.DelAccountRunnable paramDelAccountRunnable, String paramString) {}
  
  public void run()
  {
    if ((AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0)).a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0.a != null)
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0.a.dismiss();
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0.a = null;
      }
      return;
      if ((AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$DelAccountRunnable.this$0)).a(this.jdField_a_of_type_JavaLangString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.DelAccountRunnable.1
 * JD-Core Version:    0.7.0.1
 */