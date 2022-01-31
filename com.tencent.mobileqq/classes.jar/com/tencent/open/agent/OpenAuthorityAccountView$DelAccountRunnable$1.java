package com.tencent.open.agent;

import bdjz;
import bffw;

class OpenAuthorityAccountView$DelAccountRunnable$1
  implements Runnable
{
  OpenAuthorityAccountView$DelAccountRunnable$1(OpenAuthorityAccountView.DelAccountRunnable paramDelAccountRunnable, String paramString) {}
  
  public void run()
  {
    if (((OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0) instanceof PublicFragmentActivityForOpenSDK)) && (OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0) != null)) {
      OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0).a(this.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0.a != null)
      {
        this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0.a.dismiss();
        this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0.a = null;
      }
      return;
      if ((OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$DelAccountRunnable.this$0)).a(this.jdField_a_of_type_JavaLangString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.DelAccountRunnable.1
 * JD-Core Version:    0.7.0.1
 */