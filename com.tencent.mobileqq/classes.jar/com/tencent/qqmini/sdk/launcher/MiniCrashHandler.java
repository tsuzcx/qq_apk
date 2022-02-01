package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniDexConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniCrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String TAG = "MiniCrashHandler";
  public Thread.UncaughtExceptionHandler defaultHandler = null;
  
  public MiniCrashHandler()
  {
    if (this.defaultHandler == null) {
      this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public void saveCrashInfo()
  {
    try
    {
      MiniDexConfig localMiniDexConfig = MiniAppDexLoader.g().getDexConfig();
      if (localMiniDexConfig == null) {
        return;
      }
      localMiniDexConfig.addCrashInfo();
      QMLog.i("MiniCrashHandler", "save crash info completed.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniCrashHandler", "save crash info exception!", localThrowable);
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QMLog.e("MiniCrashHandler", "uncaughtException ", paramThrowable);
    saveCrashInfo();
    if (this.defaultHandler != null) {
      this.defaultHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniCrashHandler
 * JD-Core Version:    0.7.0.1
 */