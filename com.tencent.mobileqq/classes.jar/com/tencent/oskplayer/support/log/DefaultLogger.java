package com.tencent.oskplayer.support.log;

import android.util.Log;

public class DefaultLogger
  implements ILogger
{
  public static final String TAG = "OskPlayer";
  
  public int d(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.d(localStringBuilder.toString(), paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.d(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.e(localStringBuilder.toString(), paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.e(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.i(localStringBuilder.toString(), paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.i(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int v(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.v(localStringBuilder.toString(), paramString2);
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.v(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int w(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.w(localStringBuilder.toString(), paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString1);
    return Log.w(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OskPlayer/");
    localStringBuilder.append(paramString);
    return Log.w(localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.support.log.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */