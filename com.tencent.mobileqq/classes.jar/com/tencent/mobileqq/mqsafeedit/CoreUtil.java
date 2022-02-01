package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import java.io.File;

public class CoreUtil
{
  public static String getTxLib(Context paramContext)
  {
    paramContext = new StringBuilder(String.valueOf(paramContext.getFilesDir().getParent()));
    paramContext.append("/txlib/");
    return paramContext.toString();
  }
  
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    Object localObject = new StringBuilder(String.valueOf(getTxLib(paramContext)));
    ((StringBuilder)localObject).append("lib");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".so");
    File localFile = new File(((StringBuilder)localObject).toString());
    localObject = localFile;
    if (!localFile.exists())
    {
      paramContext = new StringBuilder(String.valueOf(paramContext.getFilesDir().getParent()));
      paramContext.append("/lib/lib");
      paramContext.append(paramString);
      paramContext.append(".so");
      localObject = new File(paramContext.toString());
    }
    if (((File)localObject).exists()) {}
    try
    {
      System.load(((File)localObject).getAbsolutePath());
      bool = true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      boolean bool;
      label134:
      break label134;
    }
    bool = false;
    if (!bool) {}
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError paramString) {}
    return bool;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.CoreUtil
 * JD-Core Version:    0.7.0.1
 */