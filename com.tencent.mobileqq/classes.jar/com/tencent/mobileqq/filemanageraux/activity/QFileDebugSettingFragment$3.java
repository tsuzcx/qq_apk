package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$3(QFileDebugSettingFragment paramQFileDebugSettingFragment, IQFileFileReaderConfigBean paramIQFileFileReaderConfigBean) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.setIsShowReaderBar(paramBoolean);
    QFileDebugSettingFragment.a(this.b).setFileReaderConfig();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */