package com.tencent.rmonitor.common.logger;

public class NativeLogger
{
  private static final String TAG = "RMonitor_NativeLogger";
  private static NativeLogger mInstance;
  private static boolean mSoLoadSuccess;
  
  static
  {
    try
    {
      System.loadLibrary("rmonitor_log");
      mSoLoadSuccess = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_NativeLogger", localThrowable);
      mSoLoadSuccess = false;
    }
  }
  
  public static NativeLogger getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new NativeLogger();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static native void initLogLevelNative(int paramInt);
  
  public int initLogLevel(int paramInt)
  {
    if (mSoLoadSuccess)
    {
      initLogLevelNative(paramInt);
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logger.NativeLogger
 * JD-Core Version:    0.7.0.1
 */