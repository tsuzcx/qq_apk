package com.tencent.mobileqq.vip;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class TMSManager$DynamicLoadHelper
{
  public String a(Context paramContext)
  {
    paramContext = paramContext.getDir("lib", 0).getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "kcsdk_4.4.7.3661.jar";
    }
    return paramContext + File.separator + "kcsdk_4.4.7.3661.jar";
  }
  
  protected void a()
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((IVasQuickUpdateService)localAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "kcsdk_4_4_7_3661", "KC.TMSManager");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        String str = paramContext.getDir("lib", 0).getAbsolutePath();
        paramContext = TMSManager.a().b(paramContext);
        if (VasSoUtils.a(paramContext, str, "kcsdk_4.4.7.3661.jar"))
        {
          QLog.d("KC.TMSManager", 1, "unzip succ");
          TMSManager.a(TMSManager.a());
          return;
        }
        QLog.e("KC.TMSManager", 1, new Object[] { "unzip error, libDir=" + str, " zipPath=" + paramContext });
        continue;
        QLog.e("KC.TMSManager", 1, "error: " + paramInt);
      }
      finally {}
    }
  }
  
  public String b(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "libtmsdualcore.zip";
    }
    return paramContext + File.separator + "libtmsdualcore.zip";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager.DynamicLoadHelper
 * JD-Core Version:    0.7.0.1
 */