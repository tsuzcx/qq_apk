package com.tencent.rmonitor.common.logger;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logger/Logger;", "Lcom/tencent/rmonitor/common/logger/ILoger;", "()V", "DEFAULT_PROXY", "Lcom/tencent/rmonitor/common/logger/ILogProxy;", "TAG", "", "debug", "", "intLevel", "", "getIntLevel", "()I", "setIntLevel", "(I)V", "level", "Lcom/tencent/rmonitor/common/logger/LogState;", "logLevel", "getLogLevel", "()Lcom/tencent/rmonitor/common/logger/LogState;", "setLogLevel", "(Lcom/tencent/rmonitor/common/logger/LogState;)V", "value", "logProxy", "getLogProxy", "()Lcom/tencent/rmonitor/common/logger/ILogProxy;", "setLogProxy", "(Lcom/tencent/rmonitor/common/logger/ILogProxy;)V", "logTimeFormatter", "Ljava/text/SimpleDateFormat;", "d", "", "args", "", "([Ljava/lang/String;)V", "e", "exception", "tag", "msg", "throwable", "", "getThrowableMessage", "i", "resetLogLevel", "v", "w", "DefaultLogProxy", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class Logger
  implements ILoger
{
  @JvmField
  public static boolean a;
  public static final Logger b = new Logger();
  private static final ILogProxy c = (ILogProxy)new Logger.DefaultLogProxy();
  private static SimpleDateFormat d = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
  @NotNull
  private static LogState e = LogState.WARN;
  @Nullable
  private static ILogProxy f = c;
  private static int intLevel = LogState.WARN.getValue();
  
  @NotNull
  public final LogState a()
  {
    return e;
  }
  
  @NotNull
  public final String a(@Nullable Throwable paramThrowable)
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
  
  public final void a(int paramInt)
  {
    LogState localLogState = LogState.Companion.a(paramInt);
    if (localLogState == null) {
      localLogState = LogState.OFF;
    }
    a(localLogState);
  }
  
  public final void a(@Nullable ILogProxy paramILogProxy)
  {
    synchronized (b.getClass())
    {
      f = paramILogProxy;
      paramILogProxy = Unit.INSTANCE;
      return;
    }
  }
  
  public final void a(@NotNull LogState paramLogState)
  {
    Intrinsics.checkParameterIsNotNull(paramLogState, "level");
    boolean bool;
    if (paramLogState == LogState.DEBUG) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
    e = paramLogState;
    intLevel = e.getValue();
    NativeLogger.getInstance().initLogLevel(intLevel);
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    if (paramString1 != null)
    {
      if (paramThrowable == null) {
        return;
      }
      if (e.compareTo((Enum)LogState.ERROR) >= 0)
      {
        if (paramString2 == null) {
          paramString2 = "";
        }
        e(new String[] { paramString1, paramString2, a(paramThrowable) });
      }
    }
  }
  
  public final void a(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    if (paramString != null)
    {
      if (paramThrowable == null) {
        return;
      }
      if (e.compareTo((Enum)LogState.ERROR) >= 0) {
        e(new String[] { paramString, a(paramThrowable) });
      }
    }
  }
  
  @Nullable
  public final ILogProxy b()
  {
    ILogProxy localILogProxy = f;
    if (localILogProxy != null) {
      return localILogProxy;
    }
    return c;
  }
  
  public void d(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = b();
    if (localILogProxy != null) {
      localILogProxy.a(LogState.DEBUG, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void e(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = b();
    if (localILogProxy != null) {
      localILogProxy.a(LogState.ERROR, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void i(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = b();
    if (localILogProxy != null) {
      localILogProxy.a(LogState.INFO, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void v(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = b();
    if (localILogProxy != null) {
      localILogProxy.a(LogState.VERBOS, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void w(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = b();
    if (localILogProxy != null) {
      localILogProxy.a(LogState.WARN, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logger.Logger
 * JD-Core Version:    0.7.0.1
 */