package com.tencent.qqperf;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.abfactor.AbFactorManger;
import mqq.app.MobileQQ;

public class QAPMIniter
{
  public static boolean a = false;
  
  public static int a()
  {
    if (MobileQQ.sProcessId == 2) {
      return 14;
    }
    if (MobileQQ.sProcessId == 7) {
      return 19;
    }
    return 0;
  }
  
  public static void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = a;
        if (bool) {
          return;
        }
        if (MobileQQ.sProcessId == 1) {
          AbProxy.setAbTypes(AbFactorManger.a);
        }
        a = true;
        int i = QAPM.LevelInfo;
        if (QLog.isColorLevel()) {
          i = QAPM.LevelDebug;
        }
        Object localObject1 = "edf7897a-1";
        if ((2 != MobileQQ.sProcessId) && (8 != MobileQQ.sProcessId))
        {
          String str3 = MagnifierSDK.a();
          Object localObject3 = "";
          try
          {
            String str2 = MobileQQ.getContext().getPackageManager().getApplicationInfo(MobileQQ.getContext().getPackageName(), 128).metaData.get("com.tencent.qapm.uuid").toString();
            localObject3 = str2;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("QAPM_QQ_Impl", 1, "get uuid faild", localThrowable);
          }
          QAPM.setProperty(109, MobileQQ.getContext());
          QAPM.setProperty(101, (String)localObject1);
          QAPM.setProperty(103, str3);
          QAPM.setProperty(104, (String)localObject3);
          QAPM.setProperty(105, Integer.valueOf(i));
          QAPM.setProperty(106, "https://sngapm.qq.com");
          QAPM.setProperty(107, "https://athena.qq.com");
          Logger.INSTANCE.setLogProxy(new QAPMLogImpl(i));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ensureAPMConfig ");
          ((StringBuilder)localObject1).append(i);
          QLog.i("QAPM_QQ_Impl", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      finally {}
      String str1 = "None-100";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.QAPMIniter
 * JD-Core Version:    0.7.0.1
 */