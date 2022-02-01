package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$8
  implements RadioGroup.OnCheckedChangeListener
{
  QFileDebugSettingFragment$8(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int j = 65799;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
      break;
    case 2131365390: 
      i = 65793;
      break;
    case 2131365389: 
      i = 68361;
    }
    Object localObject = this.a.getBaseActivity().app;
    BaseApplication localBaseApplication = ((QQAppInterface)localObject).getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_debug_");
    localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
    localObject = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("file_debug_dataline_device", i);
    ((SharedPreferences.Editor)localObject).apply();
    QFileDebugSettingFragment.a(this.a).setDebugDatalineSettingDevice(i);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */