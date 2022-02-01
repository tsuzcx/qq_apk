package com.tencent.open.agent;

import com.tencent.mobileqq.utils.QQCustomDialog;

class BaseAuthorityAccountView$DelAccountRunnable$1
  implements Runnable
{
  BaseAuthorityAccountView$DelAccountRunnable$1(BaseAuthorityAccountView.DelAccountRunnable paramDelAccountRunnable, String paramString) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$DelAccountRunnable.this$0.a(this.jdField_a_of_type_JavaLangString, false)) && ((this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$DelAccountRunnable.this$0.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity))) {
      ((QuickLoginAuthorityActivity)this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$DelAccountRunnable.this$0.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, false);
    }
    if (this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$DelAccountRunnable.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$DelAccountRunnable.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$DelAccountRunnable.this$0.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.DelAccountRunnable.1
 * JD-Core Version:    0.7.0.1
 */