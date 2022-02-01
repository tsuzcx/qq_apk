package com.tencent.xweb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import org.xwalk.core.XWalkEnvironment;

public class ae
{
  static String a;
  static boolean b = true;
  static boolean c;
  
  public static String a()
  {
    try
    {
      if (!TextUtils.isEmpty(a))
      {
        str = a;
        return str;
      }
      String str = XWalkEnvironment.getApplicationContext().getApplicationInfo().nativeLibraryDir;
      return str;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setForbidDownloadCode: ");
      localStringBuilder.append(paramBoolean);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", localStringBuilder.toString());
      c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = c;
      if (!bool) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.ae
 * JD-Core Version:    0.7.0.1
 */