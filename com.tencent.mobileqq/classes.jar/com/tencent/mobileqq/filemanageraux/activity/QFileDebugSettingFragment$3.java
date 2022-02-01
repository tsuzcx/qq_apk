package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$3(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ((IQFileFileReaderConfigBean)QRoute.api(IQFileFileReaderConfigBean.class)).setIsShowReaderBar(paramBoolean);
    QFileDebugSettingFragment.a(this.a).setFileReaderConfig();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */