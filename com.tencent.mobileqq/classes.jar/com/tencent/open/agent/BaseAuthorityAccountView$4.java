package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class BaseAuthorityAccountView$4
  implements View.OnClickListener
{
  BaseAuthorityAccountView$4(BaseAuthorityAccountView paramBaseAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((!this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.a(this.jdField_a_of_type_JavaLangString, true)) && ((this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity))) {
      ((QuickLoginAuthorityActivity)this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, true);
    }
    if (this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.4
 * JD-Core Version:    0.7.0.1
 */