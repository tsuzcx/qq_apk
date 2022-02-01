package com.tencent.qqmusic.mediaplayer;

import android.util.Log;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class NLog
{
  private static final int LEVEL_DEBUG = 1;
  private static final int LEVEL_ERROR = 4;
  private static final int LEVEL_INFO = 2;
  private static final int LEVEL_WARNING = 3;
  private static final String TAG = "NLog";
  private static volatile boolean mIsLoadSuccess = false;
  
  public static void D(String paramString1, String paramString2)
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return;
    }
    try
    {
      d(paramString1, paramString2);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
    }
  }
  
  public static void D(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    d(paramString1, localStringBuilder.toString());
  }
  
  public static void E(String paramString1, String paramString2)
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return;
    }
    try
    {
      e(paramString1, paramString2);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
    }
  }
  
  public static void E(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    e(paramString1, localStringBuilder.toString());
  }
  
  public static String GetLogPath()
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return "";
    }
    try
    {
      String str = getLogPath();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
    }
    return "";
  }
  
  public static void I(String paramString1, String paramString2)
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return;
    }
    try
    {
      i(paramString1, paramString2);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
    }
  }
  
  public static void I(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    i(paramString1, localStringBuilder.toString());
  }
  
  public static boolean Start(String paramString, int paramInt)
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return false;
    }
    try
    {
      boolean bool = start(paramString, paramInt);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      Logger.e("NLog", paramString);
    }
    return false;
  }
  
  public static void Stop()
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return;
    }
    try
    {
      stop();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
    }
  }
  
  public static void W(String paramString1, String paramString2)
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return;
    }
    try
    {
      w(paramString1, paramString2);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Logger.e("NLog", paramString1);
    }
  }
  
  public static void W(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    w(paramString1, localStringBuilder.toString());
  }
  
  private static void WriteLogCallback(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            Logger.i(paramString1, paramString2);
            return;
          }
          Logger.e(paramString1, paramString2);
          return;
        }
        Logger.w(paramString1, paramString2);
        return;
      }
      Logger.i(paramString1, paramString2);
      return;
    }
    Logger.d(paramString1, paramString2);
  }
  
  private static native void d(String paramString1, String paramString2);
  
  private static native void e(String paramString1, String paramString2);
  
  private static native String getLogPath();
  
  private static native void i(String paramString1, String paramString2);
  
  public static boolean init(String paramString1, String paramString2, int paramInt)
  {
    if (AudioPlayerConfigure.getSoLibraryLoader().load(paramString1))
    {
      mIsLoadSuccess = true;
      Start(paramString2, paramInt);
      return true;
    }
    return false;
  }
  
  private static native void setLogWriteCallback(int paramInt);
  
  public static void setWriteCallback(boolean paramBoolean)
  {
    if (!mIsLoadSuccess)
    {
      Logger.e("NLog", "Not load NLog lib!!!");
      return;
    }
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    try
    {
      setLogWriteCallback(i);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger.e("NLog", localUnsatisfiedLinkError);
    }
  }
  
  private static native boolean start(String paramString, int paramInt);
  
  private static native void stop();
  
  private static native void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NLog
 * JD-Core Version:    0.7.0.1
 */