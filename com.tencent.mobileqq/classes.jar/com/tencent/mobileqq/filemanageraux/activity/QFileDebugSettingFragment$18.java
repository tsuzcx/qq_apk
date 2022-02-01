package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
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
    default: 
      break;
    case 2131446429: 
      FileIPv6StrateyController.b().debugSetLocalConfigIPv6Strategy(2);
      break;
    case 2131446428: 
      FileIPv6StrateyController.b().debugSetLocalConfigIPv6Strategy(1);
      break;
    case 2131446427: 
      FileIPv6StrateyController.b().debugSetLocalConfigIPv6Strategy(0);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.18
 * JD-Core Version:    0.7.0.1
 */