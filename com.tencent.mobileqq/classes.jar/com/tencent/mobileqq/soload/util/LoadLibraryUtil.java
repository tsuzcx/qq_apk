package com.tencent.mobileqq.soload.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LoadLibraryUtil
{
  private static File a;
  
  @TargetApi(23)
  private static int a()
  {
    try
    {
      int i = Build.VERSION.PREVIEW_SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      label6:
      break label6;
    }
    return 1;
  }
  
  public static boolean a(ClassLoader paramClassLoader, File paramFile)
  {
    int i = 0;
    if ((paramClassLoader != null) && (paramFile != null)) {}
    int j;
    label51:
    label63:
    label71:
    try
    {
      if (paramFile.exists())
      {
        j = Build.VERSION.SDK_INT;
        if (j == 25)
        {
          int k = a();
          if (k != 0) {}
        }
        else
        {
          if (j <= 25) {
            break label51;
          }
        }
        i = 1;
        if (i == 0) {}
      }
    }
    finally {}
    try
    {
      LoadLibraryUtil.Api25.a(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable1)
    {
      break label63;
    }
    try
    {
      LoadLibraryUtil.Api23.a(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable2)
    {
      break label71;
    }
    LoadLibraryUtil.Api14.a(paramClassLoader, paramFile);
    break label112;
    if (j >= 23) {}
    try
    {
      LoadLibraryUtil.Api23.a(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable3)
    {
      label93:
      label112:
      break label93;
    }
    LoadLibraryUtil.Api14.a(paramClassLoader, paramFile);
    break label112;
    if (j >= 14) {
      LoadLibraryUtil.Api14.a(paramClassLoader, paramFile);
    }
    a = paramFile;
    return true;
    paramClassLoader = new StringBuilder();
    paramClassLoader.append("classLoader or folder is illegal ");
    paramClassLoader.append(paramFile);
    QLog.e("SoLoadWidget.LoadLibraryUtil", 1, paramClassLoader.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.LoadLibraryUtil
 * JD-Core Version:    0.7.0.1
 */