package com.tencent.mobileqq.settings.message;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class NotifyPushSettingFragment$21$1
  implements Runnable
{
  NotifyPushSettingFragment$21$1(NotifyPushSettingFragment.21 param21, String paramString) {}
  
  public void run()
  {
    boolean bool = true;
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment$21.a.getActivity(), 1, HardCodeUtil.a(2131707635), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
    NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment$21.a).a().setText(this.jdField_a_of_type_JavaLangString);
    NotifyPushSettingFragment localNotifyPushSettingFragment = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment$21.a;
    if (!NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment$21.a).a()) {}
    for (;;)
    {
      NotifyPushSettingFragment.a(localNotifyPushSettingFragment, bool, false);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.21.1
 * JD-Core Version:    0.7.0.1
 */