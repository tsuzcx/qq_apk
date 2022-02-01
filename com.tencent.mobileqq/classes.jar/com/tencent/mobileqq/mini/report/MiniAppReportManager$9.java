package com.tencent.mobileqq.mini.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;

final class MiniAppReportManager$9
  implements Runnable
{
  MiniAppReportManager$9(MiniAppConfig paramMiniAppConfig, long paramLong) {}
  
  public void run()
  {
    try
    {
      long l = CommonDataAdapter.a().a();
      String str = MiniAppReportManager.access$1100(this.val$miniAppConfig);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = MiniAppReportManager.access$1200(l, str);
        str = MiniAppReportManager.access$1300(l, MiniProgramReportHelper.getLaunchIdFromMainProcess(this.val$miniAppConfig));
        l = ((SharedPreferences)localObject).getLong(str, 0L);
        ((SharedPreferences)localObject).edit().putLong(str, this.val$addDuration + l).apply();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("recordDuration: ");
          ((StringBuilder)localObject).append(l + this.val$addDuration);
          ((StringBuilder)localObject).append(" key: ");
          ((StringBuilder)localObject).append(str);
          QLog.i("MiniAppReportManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppReportManager", 1, "recordDuration exception ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.9
 * JD-Core Version:    0.7.0.1
 */