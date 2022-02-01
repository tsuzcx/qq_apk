package com.tencent.mobileqq.config.operation;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class QQOperateManager$1
  implements Runnable
{
  QQOperateManager$1(QQOperateManager paramQQOperateManager, int paramInt) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(QQOperateManager.a()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(QQOperateManager.a());
      localStringBuilder.append("QQOperationVoIPRequestCount");
      localEditor.putInt(localStringBuilder.toString(), this.a).commit();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onDestroy.......");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperateManager.1
 * JD-Core Version:    0.7.0.1
 */