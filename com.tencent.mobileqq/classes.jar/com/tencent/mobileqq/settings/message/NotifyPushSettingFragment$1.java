package com.tencent.mobileqq.settings.message;

import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity.TimePickDialog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

class NotifyPushSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingFragment$1(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = HttpUtil.getNetWorkType();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    Object localObject;
    if (i == 0)
    {
      QQToast.a(this.a.getActivity(), 1, 2131696097, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
      localObject = this.a;
      if (!paramBoolean) {}
      for (;;)
      {
        NotifyPushSettingFragment.a((NotifyPushSettingFragment)localObject, bool1, false);
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool1 = false;
      }
    }
    if (NotifyPushSettingFragment.a(this.a).compareAndSet(true, true))
    {
      QQToast.a(this.a.getActivity(), 1, 2131698311, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
      localObject = this.a;
      if (!paramBoolean) {}
      for (bool1 = bool2;; bool1 = false)
      {
        NotifyPushSettingFragment.a((NotifyPushSettingFragment)localObject, bool1, false);
        break;
      }
    }
    NotifyPushSettingFragment.a(this.a, paramBoolean, true);
    if (paramBoolean)
    {
      localObject = HardCodeUtil.a(2131707627) + NotifyPushSettingActivity.TimePickDialog.a(3600000L);
      NotifyPushSettingFragment.a(this.a).setRightText((CharSequence)localObject);
      NotifyPushSettingFragment.a(this.a).set(true);
      long l = NetConnInfoCenter.getServerTime();
      ((CardHandler)NotifyPushSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((int)(3600L + l), "", "not_disturb_from_notify_push_setting_activity");
    }
    for (;;)
    {
      ReportClickEventHelper.a(NotifyPushSettingFragment.a(this.a), "0X800B849", paramBoolean);
      break;
      localObject = NotifyPushSettingFragment.a(this.a).a().getText().toString();
      NotifyPushSettingFragment.a(this.a).set(true);
      ((CardHandler)NotifyPushSettingFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(0, (String)localObject, "not_disturb_from_notify_push_setting_activity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */