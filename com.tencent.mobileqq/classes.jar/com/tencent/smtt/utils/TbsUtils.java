package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class TbsUtils
{
  private static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static File mDirectoryTBSShare = null;
  
  @TargetApi(9)
  public static boolean createDirectoryTBS(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      if (mDirectoryTBSShare == null) {
        try
        {
          if (paramContext.getApplicationInfo().processName.contains("com.tencent.mm"))
          {
            paramContext = QbSdk.getTbsFolderDir(paramContext);
            if ((paramContext != null) && (paramContext.isDirectory()))
            {
              paramContext = new File(paramContext, "share");
              if (paramContext != null)
              {
                if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
                  continue;
                }
                mDirectoryTBSShare = paramContext;
                paramContext.setExecutable(true, false);
                return true;
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }
  
  public static long getApkSize(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        return paramString.length() / 1024L;
      }
    }
    return 0L;
  }
  
  public static long getDirSize(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramFile != null)
    {
      l2 = l1;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int i = 0;
        while (i < paramFile.length)
        {
          l1 += paramFile[i].length();
          i += 1;
        }
        l2 = l1 / 1024L;
      }
    }
    return l2;
  }
  
  public static long getROMAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsUtils
 * JD-Core Version:    0.7.0.1
 */