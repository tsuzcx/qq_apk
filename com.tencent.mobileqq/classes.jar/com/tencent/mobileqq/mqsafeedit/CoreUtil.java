package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import java.io.File;

public class CoreUtil
{
  public static String getTxLib(Context paramContext)
  {
    return paramContext.getFilesDir().getParent() + "/txlib/";
  }
  
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    boolean bool2;
    if (paramContext == null)
    {
      bool2 = false;
      return bool2;
    }
    File localFile2 = new File(getTxLib(paramContext) + "lib" + paramString + ".so");
    File localFile1 = localFile2;
    if (!localFile2.exists()) {
      localFile1 = new File(paramContext.getFilesDir().getParent() + "/lib/lib" + paramString + ".so");
    }
    if (localFile1.exists()) {}
    for (;;)
    {
      try
      {
        System.load(localFile1.getAbsolutePath());
        bool1 = true;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        try
        {
          System.loadLibrary(paramString);
          return true;
        }
        catch (UnsatisfiedLinkError paramString)
        {
          return false;
        }
        paramContext = paramContext;
        bool1 = false;
        continue;
      }
      bool2 = bool1;
      if (bool1) {
        break;
      }
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.CoreUtil
 * JD-Core Version:    0.7.0.1
 */