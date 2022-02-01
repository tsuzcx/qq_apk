package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanager.api.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$1(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((IQFileAppStorePromoteConfigBean)QRoute.api(IQFileAppStorePromoteConfigBean.class)).setActionSwitch(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */