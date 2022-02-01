package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/utils/Logger;", "", "()V", "<set-?>", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "delegate", "getDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "cd", "", "tag", "", "message", "throwable", "", "ce", "ci", "cv", "cw", "d", "e", "i", "init", "v", "w", "Triton_release"}, k=1, mv={1, 1, 16})
public final class Logger
{
  public static final Logger INSTANCE = new Logger();
  @NotNull
  private static LogDelegate delegate;
  
  @JvmStatic
  @JvmOverloads
  public static final void cd(@NotNull String paramString1, @NotNull String paramString2)
  {
    cd$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void cd(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printConsoleLog(LogDelegate.Level.DEBUG, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void ce(@NotNull String paramString1, @NotNull String paramString2)
  {
    ce$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void ce(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printConsoleLog(LogDelegate.Level.ERROR, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void ci(@NotNull String paramString1, @NotNull String paramString2)
  {
    ci$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void ci(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printConsoleLog(LogDelegate.Level.INFO, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void cv(@NotNull String paramString1, @NotNull String paramString2)
  {
    cv$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void cv(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printConsoleLog(LogDelegate.Level.VERBOSE, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void cw(@NotNull String paramString1, @NotNull String paramString2)
  {
    cw$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void cw(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printConsoleLog(LogDelegate.Level.WARN, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    d$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void d(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printLog(LogDelegate.Level.DEBUG, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void e(@NotNull String paramString1, @NotNull String paramString2)
  {
    e$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void e(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printLog(LogDelegate.Level.ERROR, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void i(@NotNull String paramString1, @NotNull String paramString2)
  {
    i$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void i(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printLog(LogDelegate.Level.INFO, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void v(@NotNull String paramString1, @NotNull String paramString2)
  {
    v$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void v(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printLog(LogDelegate.Level.VERBOSE, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void w(@NotNull String paramString1, @NotNull String paramString2)
  {
    w$default(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void w(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.printLog(LogDelegate.Level.WARN, paramString1, paramString2, paramThrowable);
  }
  
  @NotNull
  public final LogDelegate getDelegate()
  {
    LogDelegate localLogDelegate = delegate;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    return localLogDelegate;
  }
  
  public final void init(@NotNull LogDelegate paramLogDelegate)
  {
    Intrinsics.checkParameterIsNotNull(paramLogDelegate, "delegate");
    delegate = paramLogDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.Logger
 * JD-Core Version:    0.7.0.1
 */