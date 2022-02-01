package com.tencent.mobileqq.settings.message;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AssistantSettingFragment$1$1
  implements Runnable
{
  AssistantSettingFragment$1$1(AssistantSettingFragment.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$1.a.a.notifyDataSetChanged();
    BaseApplication localBaseApplication = AssistantSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$1.a).getApp();
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131700996;
    } else {
      i = 2131700992;
    }
    QQToast.a(localBaseApplication, HardCodeUtil.a(i), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.1.1
 * JD-Core Version:    0.7.0.1
 */