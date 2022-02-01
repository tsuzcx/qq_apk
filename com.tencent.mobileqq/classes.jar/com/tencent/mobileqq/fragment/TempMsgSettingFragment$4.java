package com.tencent.mobileqq.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TempMsgSettingFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  TempMsgSettingFragment$4(TempMsgSettingFragment paramTempMsgSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((TempMsgManager)this.a.a.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a((short)-23310, paramBoolean, true);
    ReportController.b(this.a.a, "dc00898", "", "", "0X8009976", "0X8009976", 4, 4, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */