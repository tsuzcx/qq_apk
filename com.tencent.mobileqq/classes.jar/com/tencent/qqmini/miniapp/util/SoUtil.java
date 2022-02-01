package com.tencent.qqmini.miniapp.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class SoUtil
{
  private static volatile Boolean a;
  
  public static boolean a()
  {
    try
    {
      if (a == null) {
        if (Build.VERSION.SDK_INT < 21) {
          a = Boolean.valueOf(false);
        } else if (Build.VERSION.SDK_INT >= 23) {
          a = Boolean.valueOf(Process.is64Bit());
        } else {
          a = Boolean.valueOf(b());
        }
      }
      boolean bool = a.booleanValue();
      return bool;
    }
    finally {}
  }
  
  private static boolean b()
  {
    try
    {
      String str = (String)Reflect.on(Context.class.getClassLoader()).call("findLibrary", new Object[] { "art" }).get();
      if (str != null)
      {
        boolean bool = str.contains("lib64");
        return bool;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isArt64 fail");
      localStringBuilder.append(localException);
      QMLog.e("SoUtil", localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.SoUtil
 * JD-Core Version:    0.7.0.1
 */