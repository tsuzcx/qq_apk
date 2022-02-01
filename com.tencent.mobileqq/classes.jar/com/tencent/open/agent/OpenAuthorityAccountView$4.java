package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class OpenAuthorityAccountView$4
  implements View.OnClickListener
{
  OpenAuthorityAccountView$4(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (((OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) instanceof PublicFragmentActivityForOpenSDK)) && (OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) != null)) {
      OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView).a(this.jdField_a_of_type_JavaLangString, true);
    }
    for (;;)
    {
      if (OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) != null) {
        OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView)).a(this.jdField_a_of_type_JavaLangString, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.4
 * JD-Core Version:    0.7.0.1
 */