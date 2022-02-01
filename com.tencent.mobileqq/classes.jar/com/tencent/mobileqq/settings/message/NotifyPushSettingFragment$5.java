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
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, new Object[] { "avCallOnCheckedChangeListener::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!NotifyPushSettingFragment.a(this.a).c())
    {
      NotifyPushSettingFragment.a(this.a).a(this.a.getBaseActivity());
      NotifyPushSettingFragment.a(this.a).setOnCheckedChangeListener(null);
      NotifyPushSettingFragment.a(this.a).setChecked(true ^ NotifyPushSettingFragment.a(this.a).a());
      NotifyPushSettingFragment.a(this.a).setOnCheckedChangeListener(this.a.a);
    }
    else
    {
      AVUtil.a(NotifyPushSettingFragment.a(this.a).getCurrentAccountUin(), paramBoolean);
      ReportClickEventHelper.a(NotifyPushSettingFragment.a(this.a), "0X800B846", paramBoolean);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isChecked[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.d("IphoneTitleBarFragment", 2, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */