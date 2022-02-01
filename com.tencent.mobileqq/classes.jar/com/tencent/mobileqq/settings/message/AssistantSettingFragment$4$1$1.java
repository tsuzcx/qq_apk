package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.qassistant.wake.WakeDialog;
import com.tencent.mobileqq.widget.QQToast;

class AssistantSettingFragment$4$1$1
  implements Runnable
{
  AssistantSettingFragment$4$1$1(AssistantSettingFragment.4.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      new WakeDialog(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$4$1.a.a.getBaseActivity(), false).show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$4$1.a.a.getBaseActivity(), 2131695321, 0).a();
    AssistantSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$4$1.a.a, false, AssistantSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$4$1.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.4.1.1
 * JD-Core Version:    0.7.0.1
 */