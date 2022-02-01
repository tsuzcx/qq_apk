package com.tencent.qqmini.sdk.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class SDKMiniProgramLpReportDC04239$16
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$16(MiniAppInfo paramMiniAppInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
      Object localObject = SDKMiniProgramLpReportDC04239.access$700(this.val$miniAppConfig);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = SDKMiniProgramLpReportDC04239.access$800(str, (String)localObject);
        str = SDKMiniProgramLpReportDC04239.access$900(str, MiniProgramReportHelper.getLaunchIdFromMainProcess(this.val$miniAppConfig));
        long l = ((SharedPreferences)localObject).getLong(str, 0L);
        ((SharedPreferences)localObject).edit().putLong(str, this.val$addDuration + l).apply();
        QMLog.i("MiniProgramLpReportDC04239", "recordDuration: " + (l + this.val$addDuration) + " key: " + str);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniProgramLpReportDC04239", "recordDuration exception ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.16
 * JD-Core Version:    0.7.0.1
 */