package com.tencent.open.base;

import android.text.TextUtils;

public class BspatchUtil
{
  protected static final String a = "com.tencent.open.base.BspatchUtil";
  protected static boolean b = false;
  
  static
  {
    try
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("bspatch");
      b = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load bspatch error : ");
      localStringBuilder.append(localThrowable.toString());
      LogUtility.e(str, localStringBuilder.toString());
      b = false;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("srcFile = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\npatchFile = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\ndstFile = ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\nisSupport = ");
    localStringBuilder.append(String.valueOf(b));
    LogUtility.b(str, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (!b) {
        return false;
      }
      try
      {
        boolean bool = bspatch(paramString1, paramString3, paramString2);
        return bool;
      }
      catch (Throwable paramString1)
      {
        paramString2 = a;
        paramString3 = new StringBuilder();
        paramString3.append("patch error : ");
        paramString3.append(paramString1.toString());
        LogUtility.e(paramString2, paramString3.toString());
      }
    }
    return false;
  }
  
  protected static native boolean bspatch(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.BspatchUtil
 * JD-Core Version:    0.7.0.1
 */