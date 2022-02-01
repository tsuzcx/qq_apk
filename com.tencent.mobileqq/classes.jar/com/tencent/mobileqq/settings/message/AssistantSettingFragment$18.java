package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AssistantSettingFragment$18
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$18(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click extend friend setting, isChecked = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AssistantSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).setExtendFriendUserSwitch(AssistantSettingFragment.c(this.a), paramBoolean, "", System.currentTimeMillis());
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).setExtendFriendSwitch(AssistantSettingFragment.c(this.a), paramBoolean, new -..Lambda.AssistantSettingFragment.18.oQNi9WNp9rLPmUGmsn3NiyGAGgY(this, paramBoolean));
    Object localObject = AssistantSettingFragment.c(this.a);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800BDC5", "0X800BDC5", i, 0, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.18
 * JD-Core Version:    0.7.0.1
 */