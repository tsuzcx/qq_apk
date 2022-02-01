package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
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
    if ((NetworkUtil.isNetworkAvailable(this.b.getBaseActivity().getApplicationContext())) && (NotifyPushSettingFragment.q(this.b)))
    {
      this.a.d(paramBoolean);
    }
    else
    {
      NotifyPushSettingFragment.b(this.b, false);
      NotifyPushSettingFragment.r(this.b).setChecked(NotifyPushSettingFragment.r(this.b).a() ^ true);
      NotifyPushSettingFragment.b(this.b, true);
      QQToast.makeText(this.b.getBaseActivity(), NotifyPushSettingFragment.c(this.b).getApplication().getString(2131892406), 0).show(5);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */