package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class p
{
  private static File a;
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a == null) {
      try
      {
        if (!paramContext.getApplicationInfo().processName.contains("com.tencent.mm")) {
          return false;
        }
        paramContext = QbSdk.getTbsFolderDir(paramContext);
        if (paramContext != null)
        {
          if (!paramContext.isDirectory()) {
            return false;
          }
          paramContext = new File(paramContext, "share");
          if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
            return false;
          }
          a = paramContext;
          paramContext.setExecutable(true, false);
          return true;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.p
 * JD-Core Version:    0.7.0.1
 */