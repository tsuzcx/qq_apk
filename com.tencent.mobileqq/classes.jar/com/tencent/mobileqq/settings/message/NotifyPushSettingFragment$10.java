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
    if (AppSetting.e) {
      NotifyPushSettingFragment.n(this.b).setContentDescription("PC离线时自动启动QQ手机版");
    }
    ReportClickEventHelper.a(NotifyPushSettingFragment.c(this.b), "0X800B84F", paramBoolean);
    if ((NetworkUtil.isNetworkAvailable(this.b.getBaseActivity().getApplicationContext())) && (NotifyPushSettingFragment.o(this.b)))
    {
      if (!NotifyPushSettingFragment.p(this.b)) {
        this.a.b(paramBoolean);
      }
    }
    else
    {
      NotifyPushSettingFragment.a(this.b, false);
      NotifyPushSettingFragment.n(this.b).setChecked(NotifyPushSettingFragment.n(this.b).a() ^ true);
      NotifyPushSettingFragment.a(this.b, true);
      QQToast.makeText(this.b.getBaseActivity(), NotifyPushSettingFragment.c(this.b).getApplication().getString(2131892406), 0).show(5);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */