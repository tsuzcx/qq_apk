package com.tencent.mobileqq.settings.message;

import android.animation.AnimatorListenerAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class NotifyPushSettingFragment$16
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$16(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.a.b())
    {
      NotifyPushSettingFragment.a(this.a).a(this.a.getBaseActivity());
      NotifyPushSettingFragment.h(this.a).setOnCheckedChangeListener(null);
      NotifyPushSettingFragment.h(this.a).setChecked(true ^ NotifyPushSettingFragment.h(this.a).a());
      NotifyPushSettingFragment.h(this.a).setOnCheckedChangeListener(this.a.b);
    }
    else
    {
      NotifyPushSettingFragment.h(this.a).a().setClickable(false);
      Object localObject;
      if (paramBoolean)
      {
        localObject = new NotifyPushSettingFragment.16.1(this);
        NotifyPushSettingFragment localNotifyPushSettingFragment = this.a;
        NotifyPushSettingFragment.a(localNotifyPushSettingFragment, NotifyPushSettingFragment.a(localNotifyPushSettingFragment), (AnimatorListenerAdapter)localObject);
        if (!NotifyPushSettingFragment.e(this.a))
        {
          NotifyPushSettingFragment.c(this.a, true);
          ReportController.a(NotifyPushSettingFragment.a(this.a), "0X800B7E1");
        }
      }
      else
      {
        localObject = this.a;
        NotifyPushSettingFragment.a((NotifyPushSettingFragment)localObject, NotifyPushSettingFragment.a((NotifyPushSettingFragment)localObject), NotifyPushSettingFragment.h(this.a).a());
      }
      if (ForegroundNotifyManager.a(NotifyPushSettingFragment.a(this.a)).h()) {
        NotifyPushSettingFragment.a(this.a).setVisibility(8);
      }
      SettingCloneUtil.writeValue(NotifyPushSettingFragment.a(this.a).getApp(), NotifyPushSettingFragment.a(this.a).getCurrentUin(), null, "new_msg_notification_key", paramBoolean);
      PushNoticeUtil.a(paramBoolean);
      ReportClickEventHelper.a(NotifyPushSettingFragment.a(this.a), "0X800B844", paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.16
 * JD-Core Version:    0.7.0.1
 */