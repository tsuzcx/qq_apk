package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;
import mqq.app.AppRuntime;

class AssistantSettingFragment$40
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingFragment$40(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = this.a.g.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.a.g.getChildAt(i);
      if ((localObject instanceof FormSwitchItem))
      {
        localObject = (FormSwitchItem)localObject;
        if (paramCompoundButton == ((FormSwitchItem)localObject).getSwitch()) {
          break label70;
        }
      }
      i += 1;
    }
    Object localObject = null;
    label70:
    if ((localObject != null) && ((((FormSwitchItem)localObject).getTag() instanceof CTEntry)))
    {
      CTEntry localCTEntry = (CTEntry)((FormSwitchItem)localObject).getTag();
      localCTEntry.m = (paramBoolean ^ true);
      if (this.a.i != null) {
        this.a.i.a(localCTEntry, localCTEntry.m);
      }
      localObject = AssistantSettingFragment.c(this.a);
      j = localCTEntry.a;
      if (localCTEntry.m) {
        i = 2;
      } else {
        i = 1;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X80097A0", "0X80097A0", j, 0, String.valueOf(i), "", "", "");
      if (localCTEntry.a == 3)
      {
        QQAppInterface localQQAppInterface = AssistantSettingFragment.c(this.a);
        if (paramBoolean) {
          localObject = "0X8009C0A";
        } else {
          localObject = "0X8009C0B";
        }
        String str;
        if (paramBoolean) {
          str = "0X8009C0A";
        } else {
          str = "0X8009C0B";
        }
        ReportController.b(localQQAppInterface, "dc00898", "", "", (String)localObject, str, localCTEntry.a, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.40
 * JD-Core Version:    0.7.0.1
 */