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

class AssistantSettingFragment$38
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$38(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      AssistantSettingFragment.a(this.a, 2131889169, 1);
      AssistantSettingFragment.h(this.a).setOnCheckedChangeListener(null);
      AssistantSettingFragment.h(this.a).setChecked(paramCompoundButton.isChecked() ^ true);
      AssistantSettingFragment.h(this.a).setOnCheckedChangeListener(this);
    }
    else
    {
      ((C2CShortcutBarManager)AssistantSettingFragment.c(this.a).getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean);
      ReportClickEventHelper.a(AssistantSettingFragment.c(this.a), "0X800B881", paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.38
 * JD-Core Version:    0.7.0.1
 */