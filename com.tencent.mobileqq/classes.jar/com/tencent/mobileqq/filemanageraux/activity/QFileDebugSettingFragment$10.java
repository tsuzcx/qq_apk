package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.config.business.qfile.IQFileDatalineConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$10
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$10(QFileDebugSettingFragment paramQFileDebugSettingFragment, IQFileDatalineConfigBean paramIQFileDatalineConfigBean) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileDatalineConfigBean.b(paramBoolean);
    QFileDebugSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxActivityQFileDebugSettingFragment).setDatalineConfig();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.10
 * JD-Core Version:    0.7.0.1
 */