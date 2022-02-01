package com.tencent.mobileqq.minigame.utils;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.qphone.base.util.QLog;

public class GameLog
  implements ITLog
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
  
  public void printNativeLog(int paramInt, String paramString1, String paramString2)
  {
    if (getInstance() == null)
    {
      QLog.i("[minigame] ", 1, "g_printNativeLog getLog null");
      QLog.i("[minigame] " + paramString1, 1, paramString2);
    }
    label273:
    for (;;)
    {
      return;
      String str = paramString2;
      if (!TextUtils.isEmpty(mPreLogInfo))
      {
        if (!mPreLogInfo.equals(paramString2)) {
          break label200;
        }
        mRepeatLogInfoNumber += 1L;
        if (mRepeatLogInfoNumber >= 9223372036854775807L) {
          mRepeatLogInfoNumber = 0L;
        }
        label83:
        str = paramString2;
        if (mRepeatLogInfoNumber > 10L)
        {
          if (mRepeatLogInfoNumber % 10L != 0L) {
            continue;
          }
          str = paramString2 + "[ repeat " + mRepeatLogInfoNumber + "]";
        }
      }
      int i;
      if (paramInt >= 100)
      {
        i = paramInt - 100 + 3;
        label154:
        if (i > 3) {
          break label217;
        }
        getInstance().d(paramString1, str);
      }
      for (;;)
      {
        if (paramInt < 100) {
          break label273;
        }
        paramInt -= 100;
        if (paramInt >= VCONSOLE_LOG_ARRAY.length) {
          break;
        }
        printVconsoleLog(VCONSOLE_LOG_ARRAY[paramInt], str);
        return;
        label200:
        mRepeatLogInfoNumber = 0L;
        mPreLogInfo = paramString2;
        break label83;
        i = paramInt;
        break label154;
        label217:
        if (i == 4) {
          getInstance().i(paramString1, str);
        } else if (i == 5) {
          getInstance().w(paramString1, str);
        } else if (i == 6) {
          getInstance().e(paramString1, str);
        }
      }
    }
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