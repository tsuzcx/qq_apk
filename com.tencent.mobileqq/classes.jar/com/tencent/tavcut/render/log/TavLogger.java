package com.tencent.tavcut.render.log;

import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/log/TavLogger;", "", "()V", "iLogProxy", "Lcom/tencent/tavcut/render/log/ILogProxy;", "level", "", "d", "", "tag", "", "message", "e", "t", "", "i", "proxyTavLog", "setLevel", "setProxy", "v", "w", "DefaultLogProxy", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TavLogger
{
  public static final TavLogger a;
  private static ILogProxy b;
  private static int c;
  
  static
  {
    TavLogger localTavLogger = new TavLogger();
    a = localTavLogger;
    b = (ILogProxy)new TavLogger.DefaultLogProxy();
    c = 2;
    c = 2147483647;
    localTavLogger.a();
  }
  
  private final void a()
  {
    Logger.setLogProxy((ILog)new TavLogger.proxyTavLog.1());
    Logger.setLevel(c);
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    c = paramInt;
  }
  
  @JvmStatic
  public static final void a(@NotNull ILogProxy paramILogProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramILogProxy, "iLogProxy");
    b = paramILogProxy;
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (c > 2) {
      return;
    }
    b.a(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    if (c > 6) {
      return;
    }
    b.a(paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  public static final void b(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (c > 3) {
      return;
    }
    b.b(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void c(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (c > 4) {
      return;
    }
    b.c(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void d(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (c > 5) {
      return;
    }
    b.d(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void e(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (c > 6) {
      return;
    }
    b.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.log.TavLogger
 * JD-Core Version:    0.7.0.1
 */