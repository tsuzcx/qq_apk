package com.tencent.mobileqq.settings.message;

import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class NotifyPushSettingFragment$11
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$11(NotifyPushSettingFragment paramNotifyPushSettingFragment, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment.getActivity().getApplicationContext())) && (NotifyPushSettingFragment.d(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.e(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    NotifyPushSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment, false);
    FormSwitchItem localFormSwitchItem = NotifyPushSettingFragment.g(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment);
    if (!NotifyPushSettingFragment.g(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment).a()) {}
    for (boolean bool = true;; bool = false)
    {
      localFormSwitchItem.setChecked(bool);
      NotifyPushSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment, true);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment.getActivity(), NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment).getApplication().getString(2131694730), 0).b(5);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */