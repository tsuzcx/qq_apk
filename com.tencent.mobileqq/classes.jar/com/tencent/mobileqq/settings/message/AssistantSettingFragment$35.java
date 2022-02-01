package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingFragment$35
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$35(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      AssistantSettingFragment.a(this.a, 2131692183, 1);
      AssistantSettingFragment.c(this.a).setOnCheckedChangeListener(null);
      AssistantSettingFragment.c(this.a).setChecked(paramCompoundButton.isChecked() ^ true);
      AssistantSettingFragment.c(this.a).setOnCheckedChangeListener(this);
    }
    else
    {
      ((C2CShortcutBarManager)AssistantSettingFragment.a(this.a).getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean);
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B881", paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.35
 * JD-Core Version:    0.7.0.1
 */