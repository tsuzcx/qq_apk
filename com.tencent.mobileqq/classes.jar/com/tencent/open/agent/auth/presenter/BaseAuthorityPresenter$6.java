package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.auth.IBaseView;
import com.tencent.open.agent.util.AuthReporter;

class BaseAuthorityPresenter$6
  implements Runnable
{
  BaseAuthorityPresenter$6(BaseAuthorityPresenter paramBaseAuthorityPresenter, int paramInt, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.b();
    this.this$0.jdField_a_of_type_ComTencentOpenAgentAuthIBaseView.a(true);
    BaseAuthorityPresenter localBaseAuthorityPresenter = this.this$0;
    localBaseAuthorityPresenter.jdField_d_of_type_Boolean = true;
    AuthReporter.a(localBaseAuthorityPresenter.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.this$0.jdField_d_of_type_JavaLangString, this.this$0.a());
    AuthReporter.a(this.this$0.jdField_d_of_type_JavaLangString, "0X800B65F");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter.6
 * JD-Core Version:    0.7.0.1
 */