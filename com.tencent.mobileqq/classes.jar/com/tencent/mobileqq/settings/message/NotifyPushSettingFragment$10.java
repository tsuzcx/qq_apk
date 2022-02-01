package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class NotifyPushSettingFragment$10
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$10(NotifyPushSettingFragment paramNotifyPushSettingFragment, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d) {
      NotifyPushSettingFragment.f(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment).setContentDescription("PC离线时自动启动QQ手机版");
    }
    ReportClickEventHelper.a(NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment), "0X800B84F", paramBoolean);
    if ((NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment.getBaseActivity().getApplicationContext())) && (NotifyPushSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment)))
    {
      if (!NotifyPushSettingFragment.c(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment)) {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(paramBoolean);
      }
    }
    else
    {
      NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment, false);
      NotifyPushSettingFragment.f(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment).setChecked(NotifyPushSettingFragment.f(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment).a() ^ true);
      NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment, true);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment.getBaseActivity(), NotifyPushSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNotifyPushSettingFragment).getApplication().getString(2131694709), 0).b(5);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */