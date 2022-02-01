package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$10
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$10(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).setIpadOnline(paramBoolean);
    QFileDebugSettingFragment.a(this.a).setDatalineConfig();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */