package com.tencent.mobileqq.filemanageraux.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$5
  implements CompoundButton.OnCheckedChangeListener
{
  QFileDebugSettingFragment$5(QFileDebugSettingFragment paramQFileDebugSettingFragment, EditText paramEditText) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QFileDebugSettingFragment.a(this.b).setHarcodeIP(paramBoolean);
    this.a.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.a.setText("");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */