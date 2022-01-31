package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static final String TAG = "TbsLinuxToolsJni";
  private static boolean gJniloaded = false;
  private static boolean mbIsInited = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    init(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void init(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (mbIsInited) {
          return;
        }
        mbIsInited = true;
      }
      finally {}
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label167;
        }
        localFile1 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
        if (localFile1 != null)
        {
          File localFile3 = new File(localFile1.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
          File localFile2;
          if (localFile3 != null)
          {
            localFile2 = localFile1;
            if (localFile3.exists()) {}
          }
          else
          {
            localFile2 = localFile1;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              localFile2 = TbsInstaller.getInstance().getCoreShareDecoupleDir(paramContext);
            }
          }
          if (localFile2 != null)
          {
            System.load(localFile2.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
            gJniloaded = true;
          }
        }
        ChmodInner("/checkChmodeExists", "700");
      }
      catch (Throwable paramContext)
      {
        label167:
        paramContext.printStackTrace();
        gJniloaded = false;
        continue;
      }
      return;
      File localFile1 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
    }
  }
  
  public int Chmod(String paramString1, String paramString2)
  {
    if (!gJniloaded)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLinuxToolsJni
 * JD-Core Version:    0.7.0.1
 */