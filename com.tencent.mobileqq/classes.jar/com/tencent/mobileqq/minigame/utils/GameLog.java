package com.tencent.mobileqq.minigame.utils;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GameLog
  implements LogDelegate
{
  public static final String MINIAPP_TAG = "[miniapp] ";
  public static final String MINIGAME_DEBUGGER_TAG = "[debugger].";
  public static final String MINIGAME_TAG = "[minigame] ";
  public static final String MINIGAME_TAG_START = "[minigame][start] ";
  public static final String MINIGAME_TIMECOST = "[minigame][timecost] ";
  public static final String MINIGAME_VCONSOLE_TAG = "[minigame] jsconsole";
  public static final String MINIHTTP_TAG = "[mini] http.";
  public static final String MINI_TAG = "[mini] ";
  private static final String[] VCONSOLE_LOG_ARRAY = { "log", "info", "warn", "error" };
  public static final int VCONSOLE_LOG_DEBUG = 100;
  private static String mPreLogInfo = "init log";
  private static long mRepeatLogInfoNumber;
  private static GameLog sInstance;
  
  public static String cutString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.length() < 1024) || (paramString.length() < 1024)) {
      return paramString;
    }
    return paramString.substring(0, 1023);
  }
  
  private boolean enableLog()
  {
    return GameWnsUtils.gameEnableLog();
  }
  
  public static GameLog getInstance()
  {
    if (sInstance == null) {}
    try
    {
      sInstance = new GameLog();
      return sInstance;
    }
    finally {}
  }
  
  public static void printVconsoleLog(String paramString1, String paramString2)
  {
    VConsoleLogManager localVConsoleLogManager = VConsoleManager.getInstance().getLogManager(Process.myPid());
    if (localVConsoleLogManager != null) {
      localVConsoleLogManager.injectLog(paramString1, paramString2);
    }
  }
  
  public static void vconsoleLog(String paramString)
  {
    VConsoleLogManager localVConsoleLogManager = VConsoleManager.getInstance().getLogManager(Process.myPid());
    if (localVConsoleLogManager != null) {
      localVConsoleLogManager.injectLog("error", paramString);
    }
  }
  
  public int d(String paramString1, String paramString2)
  {
    if (enableLog()) {
      QLog.i("[minigame] " + paramString1, 1, paramString2);
    }
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog()) {
      QLog.i("[minigame] " + paramString1, 1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (enableLog()) {
      QLog.e("[minigame] " + paramString1, 1, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog()) {
      QLog.e("[minigame] " + paramString1, 1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public String getLogMessage(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(mPreLogInfo))
    {
      if (!mPreLogInfo.equals(paramString)) {
        break label100;
      }
      mRepeatLogInfoNumber += 1L;
      if (mRepeatLogInfoNumber >= 9223372036854775807L) {
        mRepeatLogInfoNumber = 0L;
      }
    }
    for (;;)
    {
      str = paramString;
      if (mRepeatLogInfoNumber > 10L)
      {
        if (mRepeatLogInfoNumber % 10L != 0L) {
          break;
        }
        str = paramString + "[ repeat " + mRepeatLogInfoNumber + "]";
      }
      return str;
      label100:
      mRepeatLogInfoNumber = 0L;
      mPreLogInfo = paramString;
    }
    return null;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (enableLog()) {
      QLog.i("[minigame] " + paramString1, 1, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog()) {
      QLog.i("[minigame] " + paramString1, 1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public void printConsoleLog(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    printLog(paramLevel, paramString1, paramString2, paramThrowable);
    switch (GameLog.1.$SwitchMap$com$tencent$mobileqq$triton$utils$LogDelegate$Level[paramLevel.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      paramLevel = "log";
    }
    for (;;)
    {
      printVconsoleLog(paramLevel, paramString2);
      return;
      paramLevel = "info";
      continue;
      paramLevel = "warn";
      continue;
      paramLevel = "error";
    }
  }
  
  public void printLog(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    if (enableLog())
    {
      paramString2 = getLogMessage(paramString2);
      if (paramString2 != null) {}
    }
    else
    {
      return;
    }
    switch (GameLog.1.$SwitchMap$com$tencent$mobileqq$triton$utils$LogDelegate$Level[paramLevel.ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
      QLog.i("[minigame] " + paramString1, 1, paramString2, paramThrowable);
      return;
    case 3: 
      QLog.d("[minigame] " + paramString1, 1, paramString2, paramThrowable);
      return;
    case 4: 
      QLog.w("[minigame] " + paramString1, 1, paramString2, paramThrowable);
      return;
    }
    QLog.e("[minigame] " + paramString1, 1, paramString2, paramThrowable);
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (enableLog()) {
      QLog.w("[minigame] " + paramString1, 1, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog()) {
      QLog.w("[minigame] " + paramString1, 1, paramString2, paramThrowable);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameLog
 * JD-Core Version:    0.7.0.1
 */