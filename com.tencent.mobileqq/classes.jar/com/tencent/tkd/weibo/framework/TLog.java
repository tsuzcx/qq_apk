package com.tencent.tkd.weibo.framework;

import com.tencent.tkd.topicsdk.interfaces.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/TLog;", "", "()V", "mLogger", "Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "init", "logger", "w", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TLog
{
  public static final TLog a = new TLog();
  private static ILogger b;
  
  public final void a(@NotNull ILogger paramILogger)
  {
    Intrinsics.checkParameterIsNotNull(paramILogger, "logger");
    b = paramILogger;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    ILogger localILogger = b;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLogger");
    }
    localILogger.a(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.TLog
 * JD-Core Version:    0.7.0.1
 */