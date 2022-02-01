package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.qphone.base.util.BaseApplication;

class QFileDebugSettingFragment$6
  implements TextWatcher
{
  QFileDebugSettingFragment$6(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.a.getBaseActivity().app;
    BaseApplication localBaseApplication = ((QQAppInterface)localObject).getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_debug_");
    localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
    localObject = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    ((SharedPreferences.Editor)localObject).putString("file_debug_dataline_uin", paramEditable.toString());
    ((SharedPreferences.Editor)localObject).apply();
    QFileDebugSettingFragment.a(this.a).setDebugDatalineSettingUin(paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.6
 * JD-Core Version:    0.7.0.1
 */