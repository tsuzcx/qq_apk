package com.tencent.mobileqq.settings.message;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewTempMsgSettingFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  NewTempMsgSettingFragment$3(NewTempMsgSettingFragment paramNewTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((TempMsgManager)this.a.a.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a((short)-23166, paramBoolean, true);
    ReportController.b(this.a.a, "dc00898", "", "", "0X8009976", "0X8009976", 3, 3, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */