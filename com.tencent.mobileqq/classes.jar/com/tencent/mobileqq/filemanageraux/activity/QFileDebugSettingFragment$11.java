package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$11
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$11(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.a.getActivity().app;
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_debug_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("file_debug_wlan_only", paramBoolean);
    ((SharedPreferences.Editor)localObject).apply();
    QFileDebugSettingFragment.a(this.a).setWlanOnly(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.11
 * JD-Core Version:    0.7.0.1
 */