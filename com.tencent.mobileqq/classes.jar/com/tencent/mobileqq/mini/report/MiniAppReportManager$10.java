package com.tencent.mobileqq.mini.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bfbm;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;

final class MiniAppReportManager$10
  implements Runnable
{
  MiniAppReportManager$10(MiniAppConfig paramMiniAppConfig, String paramString) {}
  
  public void run()
  {
    try
    {
      long l = bfbm.a().a();
      String str = MiniAppReportManager.access$1100(this.val$miniAppConfig);
      if (!TextUtils.isEmpty(str))
      {
        SharedPreferences localSharedPreferences = MiniAppReportManager.access$1200(l, str);
        if (TextUtils.isEmpty(this.val$launchId)) {}
        for (str = MiniProgramReportHelper.getLaunchIdFromMainProcess(this.val$miniAppConfig);; str = this.val$launchId)
        {
          str = MiniAppReportManager.access$1300(l, str);
          localSharedPreferences.edit().remove(str).apply();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("MiniAppReportManager", 2, "clearDuration " + str);
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppReportManager", 1, "clearDuration exception ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.10
 * JD-Core Version:    0.7.0.1
 */