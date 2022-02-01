package com.tencent.mobileqq.vip;

import android.content.Context;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class TMSManager$DynamicLoadHelper
{
  public String a(Context paramContext)
  {
    paramContext = paramContext.getDir("lib", 0).getAbsolutePath();
    if (paramContext.endsWith(File.separator))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("kcsdk_4.4.7.3661.jar");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("kcsdk_4.4.7.3661.jar");
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    try
    {
      ((IVasQuickUpdateService)VasUtil.a().getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "kcsdk_4_4_7_3661", "KC.TMSManager");
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
    try
    {
      String str = paramContext.getDir("lib", 0).getAbsolutePath();
      paramContext = TMSManager.a().b(paramContext);
      if (VasSoUtils.a(paramContext, str, "kcsdk_4.4.7.3661.jar"))
      {
        QLog.d("KC.TMSManager", 1, "unzip succ");
        TMSManager.a(TMSManager.a());
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unzip error, libDir=");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" zipPath=");
        localStringBuilder.append(paramContext);
        QLog.e("KC.TMSManager", 1, new Object[] { str, localStringBuilder.toString() });
        break label162;
        paramContext = new StringBuilder();
        paramContext.append("error: ");
        paramContext.append(paramInt);
        QLog.e("KC.TMSManager", 1, paramContext.toString());
      }
      label162:
      return;
    }
    finally {}
  }
  
  public String b(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("libtmsdualcore.zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("libtmsdualcore.zip");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.TMSManager.DynamicLoadHelper
 * JD-Core Version:    0.7.0.1
 */