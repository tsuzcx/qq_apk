package com.tencent.mobileqq.config.operation;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aozd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class QQOperateManager$1
  implements Runnable
{
  public QQOperateManager$1(aozd paramaozd, int paramInt) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(aozd.a())) {
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(aozd.a() + "QQOperationVoIPRequestCount", this.a).commit();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onDestroy.......");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperateManager.1
 * JD-Core Version:    0.7.0.1
 */