package com.tencent.qqmini.sdk.core.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class ApkgLoader
{
  private static volatile ApkgLoader instance;
  private static volatile byte[] lock = new byte[0];
  
  public static ApkgLoader g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new ApkgLoader();
      }
      return instance;
    }
  }
  
  public ApkgInfo loadApkg(Context paramContext, String paramString)
  {
    File localFile = WxapkgUnpacker.getWxapkgFileInAssets(paramContext, paramString);
    paramContext = paramContext.getFilesDir().getPath() + "/mini/" + paramString;
    if (!WxapkgUnpacker.unpackSync(localFile.getPath(), paramContext)) {
      return null;
    }
    try
    {
      paramContext = ApkgInfo.loadApkgInfoFromFolderPath(paramContext, null, null);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("ApkgLoader", "", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ApkgLoader
 * JD-Core Version:    0.7.0.1
 */