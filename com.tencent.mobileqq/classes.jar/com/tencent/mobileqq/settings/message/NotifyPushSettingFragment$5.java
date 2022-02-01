package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingFragment$5
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$5(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, new Object[] { "avCallOnCheckedChangeListener::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!NotifyPushSettingFragment.a(this.a).c())
    {
      NotifyPushSettingFragment.a(this.a).a(this.a.getActivity());
      NotifyPushSettingFragment.a(this.a).setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = NotifyPushSettingFragment.a(this.a);
      if (!NotifyPushSettingFragment.a(this.a).a())
      {
        localFormSwitchItem.setChecked(bool);
        NotifyPushSettingFragment.a(this.a).setOnCheckedChangeListener(this.a.a);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      AVUtil.a(NotifyPushSettingFragment.a(this.a).getCurrentAccountUin(), paramBoolean);
      ReportClickEventHelper.a(NotifyPushSettingFragment.a(this.a), "0X800B846", paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "isChecked[" + paramBoolean + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */