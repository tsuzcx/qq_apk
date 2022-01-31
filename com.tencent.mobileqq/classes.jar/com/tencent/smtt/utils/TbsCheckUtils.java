package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class TbsCheckUtils
{
  static final String LOG_TAG = "TbsCheckUtils";
  static final String TBS_SHARE_FOLDER_NAME = "core_share";
  
  public static boolean checkOatIfNecessary(Context paramContext)
  {
    boolean bool = true;
    if (Looper.getMainLooper() != Looper.myLooper()) {
      bool = checkTbsValidity(paramContext);
    }
    return bool;
  }
  
  public static boolean checkTbsValidity(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (Build.VERSION.SDK_INT > 25) {
            return true;
          }
          paramContext = getTbsCoreShareDir(paramContext);
          if (paramContext != null)
          {
            paramContext = paramContext.listFiles(new TbsCheckUtils.1());
            int j = paramContext.length;
            i = 0;
            if (i < j)
            {
              File localFile = paramContext[i];
              if ((!localFile.isFile()) || (!localFile.exists())) {
                break label159;
              }
              if (isOatFileBroken(localFile))
              {
                TbsLog.w("TbsCheckUtils", "" + localFile + " is invalid --> check failed!");
                localFile.delete();
                return false;
              }
              TbsLog.i("TbsCheckUtils", "" + localFile + " #4 check success!");
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
      }
      return true;
      label159:
      i += 1;
    }
  }
  
  private static File getTbsCoreShareDir(Context paramContext)
  {
    File localFile = new File(QbSdk.getTbsFolderDir(paramContext), "core_share");
    if (localFile != null)
    {
      if (localFile.isDirectory())
      {
        paramContext = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        paramContext = null;
      }
      return paramContext;
    }
    return null;
  }
  
  private static boolean isOatFileBroken(File paramFile)
  {
    try
    {
      boolean bool = Elf.checkElfFile(paramFile);
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      Log.e("TbsCheckUtils", "isOatFileBroken exception: " + paramFile);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCheckUtils
 * JD-Core Version:    0.7.0.1
 */