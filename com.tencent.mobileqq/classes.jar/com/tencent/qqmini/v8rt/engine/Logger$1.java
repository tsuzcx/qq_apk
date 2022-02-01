package com.tencent.qqmini.v8rt.engine;

import android.util.Log;

final class Logger$1
  implements ILog
{
  public static final String TAG = "TV8RT";
  
  public int d(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.d(localStringBuilder.toString(), paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.d(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.e(localStringBuilder.toString(), paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.e(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.i(localStringBuilder.toString(), paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.i(localStringBuilder.toString(), paramString2, paramThrowable);
  }
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    int i = paramInt;
    if (paramInt >= 100) {
      i = paramInt - 100 + 3;
    }
    if (i <= 3)
    {
      Log.d(paramString1, paramString2);
      return;
    }
    if (i == 4)
    {
      Log.i(paramString1, paramString2);
      return;
    }
    if (i == 5)
    {
      Log.w(paramString1, paramString2);
      return;
    }
    if (i == 6) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.w(localStringBuilder.toString(), paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TV8RT/");
    localStringBuilder.append(paramString1);
    return Log.w(localStringBuilder.toString(), paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.Logger.1
 * JD-Core Version:    0.7.0.1
 */