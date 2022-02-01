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

class AssistantSettingFragment$34
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$34(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      AssistantSettingFragment.a(this.a, 2131692257, 1);
      AssistantSettingFragment.c(this.a).setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = AssistantSettingFragment.c(this.a);
      if (!paramCompoundButton.isChecked())
      {
        localFormSwitchItem.setChecked(bool);
        AssistantSettingFragment.c(this.a).setOnCheckedChangeListener(this);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((C2CShortcutBarManager)AssistantSettingFragment.a(this.a).getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean);
      ReportClickEventHelper.a(AssistantSettingFragment.a(this.a), "0X800B881", paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.34
 * JD-Core Version:    0.7.0.1
 */