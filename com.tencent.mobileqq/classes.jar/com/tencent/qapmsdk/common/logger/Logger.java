package com.tencent.qapmsdk.common.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/Logger;", "Lcom/tencent/qapmsdk/common/logger/ILoger;", "()V", "DEFAULT_PROXY", "Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "TAG", "", "debug", "", "intLevel", "", "getIntLevel", "()I", "setIntLevel", "(I)V", "level", "Lcom/tencent/qapmsdk/common/logger/LogState;", "logLevel", "getLogLevel", "()Lcom/tencent/qapmsdk/common/logger/LogState;", "setLogLevel", "(Lcom/tencent/qapmsdk/common/logger/LogState;)V", "value", "logProxy", "getLogProxy", "()Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "setLogProxy", "(Lcom/tencent/qapmsdk/common/logger/ILogProxy;)V", "logTimeFormatter", "Ljava/text/SimpleDateFormat;", "d", "", "args", "", "([Ljava/lang/String;)V", "e", "exception", "tag", "msg", "throwable", "", "getThrowableMessage", "i", "resetLogLevel", "v", "w", "DefaultLogProxy", "common_release"}, k=1, mv={1, 1, 15})
public final class Logger
  implements ILoger
{
  private static final ILogProxy DEFAULT_PROXY;
  public static final Logger INSTANCE = new Logger();
  private static final String TAG = "QAPM_common_Logger";
  @JvmField
  public static boolean debug;
  private static int intLevel = LogState.WARN.getValue();
  @NotNull
  private static LogState logLevel = LogState.WARN;
  @Nullable
  private static ILogProxy logProxy = DEFAULT_PROXY;
  private static SimpleDateFormat logTimeFormatter;
  
  static
  {
    DEFAULT_PROXY = (ILogProxy)new Logger.DefaultLogProxy();
    logTimeFormatter = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
  }
  
  public void d(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.DEBUG, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void e(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.ERROR, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public final void exception(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    if (paramString1 != null)
    {
      if (paramThrowable == null) {
        return;
      }
      if (logLevel.compareTo((Enum)LogState.ERROR) >= 0)
      {
        if (paramString2 == null) {
          paramString2 = "";
        }
        e(new String[] { paramString1, paramString2, getThrowableMessage(paramThrowable) });
      }
    }
  }
  
  public final void exception(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    if (paramString != null)
    {
      if (paramThrowable == null) {
        return;
      }
      if (logLevel.compareTo((Enum)LogState.ERROR) >= 0) {
        e(new String[] { paramString, getThrowableMessage(paramThrowable) });
      }
    }
  }
  
  public final int getIntLevel()
  {
    return intLevel;
  }
  
  @NotNull
  public final LogState getLogLevel()
  {
    return logLevel;
  }
  
  @Nullable
  public final ILogProxy getLogProxy()
  {
    ILogProxy localILogProxy = logProxy;
    if (localILogProxy != null) {
      return localILogProxy;
    }
    return DEFAULT_PROXY;
  }
  
  @NotNull
  public final String getThrowableMessage(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localStringWriter));
    paramThrowable = localStringWriter.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramThrowable, "sw.toString()");
    return paramThrowable;
  }
  
  public void i(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.INFO, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public final void resetLogLevel(int paramInt)
  {
    LogState localLogState = LogState.Companion.getByValue(paramInt);
    if (localLogState == null) {
      localLogState = LogState.OFF;
    }
    setLogLevel(localLogState);
  }
  
  public final void setIntLevel(int paramInt)
  {
    intLevel = paramInt;
  }
  
  public final void setLogLevel(@NotNull LogState paramLogState)
  {
    Intrinsics.checkParameterIsNotNull(paramLogState, "level");
    boolean bool;
    if (paramLogState == LogState.DEBUG) {
      bool = true;
    } else {
      bool = false;
    }
    debug = bool;
    logLevel = paramLogState;
    intLevel = logLevel.getValue();
  }
  
  public final void setLogProxy(@Nullable ILogProxy paramILogProxy)
  {
    synchronized (INSTANCE.getClass())
    {
      logProxy = paramILogProxy;
      paramILogProxy = Unit.INSTANCE;
      return;
    }
  }
  
  public void v(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.VERBOS, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void w(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.WARN, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.Logger
 * JD-Core Version:    0.7.0.1
 */