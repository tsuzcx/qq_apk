package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$2(QFileDebugSettingFragment paramQFileDebugSettingFragment, IQFileAppStorePromoteDialogConfigBean paramIQFileAppStorePromoteDialogConfigBean) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */