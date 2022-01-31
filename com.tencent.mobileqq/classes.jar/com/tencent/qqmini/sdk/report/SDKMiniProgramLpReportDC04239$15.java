package com.tencent.qqmini.sdk.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bhcg;
import bhcn;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public final class SDKMiniProgramLpReportDC04239$15
  implements Runnable
{
  public SDKMiniProgramLpReportDC04239$15(MiniAppInfo paramMiniAppInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
      Object localObject = bhcn.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = bhcn.a(str, (String)localObject);
        str = bhcn.a(str, bhcg.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
        long l = ((SharedPreferences)localObject).getLong(str, 0L);
        ((SharedPreferences)localObject).edit().putLong(str, this.jdField_a_of_type_Long + l).apply();
        QMLog.i("MiniProgramLpReportDC04239", "recordDuration: " + (l + this.jdField_a_of_type_Long) + " key: " + str);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniProgramLpReportDC04239", "recordDuration exception ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.15
 * JD-Core Version:    0.7.0.1
 */