package com.tencent.mobileqq.message.newmsg;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewMsgNotificationManager$1
  implements CompoundButton.OnCheckedChangeListener
{
  NewMsgNotificationManager$1(NewMsgNotificationManager paramNewMsgNotificationManager, BaseActivity paramBaseActivity, FormSwitchItem paramFormSwitchItem1, FormSwitchItem paramFormSwitchItem2) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "NEW_MSG_NOTIFICATION_KEY::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    FormSwitchItem localFormSwitchItem = this.b;
    if (paramBoolean)
    {
      i = 0;
      label129:
      localFormSwitchItem.setVisibility(i);
      if (ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h()) {
        this.b.setVisibility(8);
      }
      SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "new_msg_notification_key", paramBoolean);
      if (!paramBoolean) {
        break label227;
      }
    }
    label227:
    for (int i = j;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A511", "0X800A511", i, 0, "", "", "", "");
      break;
      i = 8;
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager.1
 * JD-Core Version:    0.7.0.1
 */