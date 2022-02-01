package com.tencent.mobileqq.wink;

import com.tencent.tav.ResourceLoadUtil;

public class WinkResManager
{
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      System.loadLibrary("v8jni");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("liblibpag.so");
      boolean bool1 = bool2;
      if (b(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("liblight-sdk.so");
        bool1 = bool2;
        if (b(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("libtav.so");
          boolean bool3 = ResourceLoadUtil.loadSoSync(localStringBuilder.toString());
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static boolean b(String paramString)
  {
    try
    {
      System.load(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.WinkResManager
 * JD-Core Version:    0.7.0.1
 */