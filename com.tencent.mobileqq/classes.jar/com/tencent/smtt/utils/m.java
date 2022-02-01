package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class m
{
  public static boolean a(Context paramContext)
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      return b(paramContext);
    }
    return true;
  }
  
  private static boolean a(File paramFile)
  {
    try
    {
      boolean bool = e.b(paramFile);
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isOatFileBroken exception: ");
      localStringBuilder.append(paramFile);
      Log.e("TbsCheckUtils", localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (Build.VERSION.SDK_INT > 25) {
          return true;
        }
        paramContext = c(paramContext);
        if (paramContext == null) {
          return true;
        }
        Object localObject = paramContext.listFiles(new m.1());
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          paramContext = localObject[i];
          if ((paramContext.isFile()) && (paramContext.exists()))
          {
            boolean bool = a(paramContext);
            if (bool)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("");
              ((StringBuilder)localObject).append(paramContext);
              ((StringBuilder)localObject).append(" is invalid --> check failed!");
              TbsLog.w("TbsCheckUtils", ((StringBuilder)localObject).toString());
              paramContext.delete();
              return false;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramContext);
            localStringBuilder.append(" #4 check success!");
            TbsLog.i("TbsCheckUtils", localStringBuilder.toString());
          }
          i += 1;
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
    }
    return true;
  }
  
  private static File c(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share");
    if ((paramContext.isDirectory()) && (paramContext.exists())) {
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */