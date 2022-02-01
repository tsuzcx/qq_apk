package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$18
  implements RadioGroup.OnCheckedChangeListener
{
  QFileDebugSettingFragment$18(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      FileIPv6StrateyController.a().a(0);
      continue;
      FileIPv6StrateyController.a().a(1);
      continue;
      FileIPv6StrateyController.a().a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.18
 * JD-Core Version:    0.7.0.1
 */