package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static boolean a = false;
  private static boolean b = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    a(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void a(Context paramContext)
  {
    label63:
    label220:
    try
    {
      TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init mbIsInited is " + b);
      if (b) {
        return;
      }
      b = true;
    }
    finally {}
    try
    {
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        localObject1 = TbsShareManager.a();
        if (localObject1 != null) {
          break label292;
        }
        localObject1 = TbsShareManager.c(paramContext);
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      a = false;
      TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init error !!! " + paramContext.getMessage() + " ## " + paramContext.getCause());
      break label220;
      break label63;
    }
    for (Object localObject1 = new File((String)localObject1);; localObject1 = p.a().q(paramContext))
    {
      if (localObject1 != null)
      {
        File localFile = new File(((File)localObject1).getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
        Object localObject2;
        if (localFile != null)
        {
          localObject2 = localObject1;
          if (localFile.exists()) {}
        }
        else
        {
          localObject2 = localObject1;
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            localObject2 = p.a().p(paramContext);
          }
        }
        if (localObject2 != null)
        {
          TbsLog.i("TbsLinuxToolsJni", "TbsLinuxToolsJni init tbsSharePath is " + ((File)localObject2).getAbsolutePath());
          System.load(((File)localObject2).getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
          a = true;
        }
      }
      ChmodInner("/checkChmodeExists", "700");
      return;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLinuxToolsJni
 * JD-Core Version:    0.7.0.1
 */