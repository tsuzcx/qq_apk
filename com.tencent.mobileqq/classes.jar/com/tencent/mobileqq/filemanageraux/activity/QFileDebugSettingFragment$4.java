package com.tencent.mobileqq.filemanageraux.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;

class QFileDebugSettingFragment$4
  implements TextWatcher
{
  QFileDebugSettingFragment$4(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    QFileDebugSettingFragment.a(this.a).setHarcodeIP(paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */