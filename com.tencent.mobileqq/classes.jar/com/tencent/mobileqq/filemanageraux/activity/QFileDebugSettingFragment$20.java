package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$20
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$20(QFileDebugSettingFragment paramQFileDebugSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().b(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.20
 * JD-Core Version:    0.7.0.1
 */