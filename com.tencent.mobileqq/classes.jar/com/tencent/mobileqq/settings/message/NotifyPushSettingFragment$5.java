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
    if (!NotifyPushSettingFragment.h(this.a).c())
    {
      NotifyPushSettingFragment.h(this.a).a(this.a.getBaseActivity());
      NotifyPushSettingFragment.i(this.a).setOnCheckedChangeListener(null);
      NotifyPushSettingFragment.i(this.a).setChecked(true ^ NotifyPushSettingFragment.i(this.a).a());
      NotifyPushSettingFragment.i(this.a).setOnCheckedChangeListener(this.a.b);
    }
    else
    {
      AVUtil.a(NotifyPushSettingFragment.c(this.a).getCurrentAccountUin(), paramBoolean);
      ReportClickEventHelper.a(NotifyPushSettingFragment.c(this.a), "0X800B846", paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */