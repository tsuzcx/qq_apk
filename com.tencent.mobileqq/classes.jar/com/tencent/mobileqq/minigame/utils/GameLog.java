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
  private static long mRepeatLogInfoNumber = 0L;
  private static GameLog sInstance;
  
  public static String cutString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 1024) {
      return paramString;
    }
    if (paramString.length() < 1024) {
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
    if (sInstance == null) {
      try
      {
        sInstance = new GameLog();
      }
      finally {}
    }
    return sInstance;
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
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.i(localStringBuilder.toString(), 1, paramString2);
    }
    return 0;
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.i(localStringBuilder.toString(), 1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.e(localStringBuilder.toString(), 1, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public String getLogMessage(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(mPreLogInfo))
    {
      if (mPreLogInfo.equals(paramString))
      {
        mRepeatLogInfoNumber += 1L;
        if (mRepeatLogInfoNumber >= 9223372036854775807L) {
          mRepeatLogInfoNumber = 0L;
        }
      }
      else
      {
        mRepeatLogInfoNumber = 0L;
        mPreLogInfo = paramString;
      }
      long l = mRepeatLogInfoNumber;
      localObject = paramString;
      if (l > 10L)
      {
        if (l % 10L == 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("[ repeat ");
          ((StringBuilder)localObject).append(mRepeatLogInfoNumber);
          ((StringBuilder)localObject).append("]");
          return ((StringBuilder)localObject).toString();
        }
        localObject = null;
      }
    }
    return localObject;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.i(localStringBuilder.toString(), 1, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.i(localStringBuilder.toString(), 1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public void printConsoleLog(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    printLog(paramLevel, paramString1, paramString2, paramThrowable);
    int i = GameLog.1.$SwitchMap$com$tencent$mobileqq$triton$utils$LogDelegate$Level[paramLevel.ordinal()];
    if (i != 1)
    {
      if (i != 4)
      {
        if (i != 5) {
          paramLevel = "log";
        } else {
          paramLevel = "error";
        }
      }
      else {
        paramLevel = "warn";
      }
    }
    else {
      paramLevel = "info";
    }
    printVconsoleLog(paramLevel, paramString2);
  }
  
  public void printLog(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    if (enableLog())
    {
      paramString2 = getLogMessage(paramString2);
      if (paramString2 == null) {
        return;
      }
      int i = GameLog.1.$SwitchMap$com$tencent$mobileqq$triton$utils$LogDelegate$Level[paramLevel.ordinal()];
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            paramLevel = new StringBuilder();
            paramLevel.append("[minigame] ");
            paramLevel.append(paramString1);
            QLog.e(paramLevel.toString(), 1, paramString2, paramThrowable);
            return;
          }
          paramLevel = new StringBuilder();
          paramLevel.append("[minigame] ");
          paramLevel.append(paramString1);
          QLog.w(paramLevel.toString(), 1, paramString2, paramThrowable);
          return;
        }
        paramLevel = new StringBuilder();
        paramLevel.append("[minigame] ");
        paramLevel.append(paramString1);
        QLog.d(paramLevel.toString(), 1, paramString2, paramThrowable);
        return;
      }
      paramLevel = new StringBuilder();
      paramLevel.append("[minigame] ");
      paramLevel.append(paramString1);
      QLog.i(paramLevel.toString(), 1, paramString2, paramThrowable);
    }
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.w(localStringBuilder.toString(), 1, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (enableLog())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[minigame] ");
      localStringBuilder.append(paramString1);
      QLog.w(localStringBuilder.toString(), 1, paramString2, paramThrowable);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameLog
 * JD-Core Version:    0.7.0.1
 */