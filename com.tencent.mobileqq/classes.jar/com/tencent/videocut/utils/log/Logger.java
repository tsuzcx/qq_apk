package com.tencent.videocut.utils.log;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/log/Logger;", "", "()V", "defaultProxy", "com/tencent/videocut/utils/log/Logger$defaultProxy$1", "Lcom/tencent/videocut/utils/log/Logger$defaultProxy$1;", "level", "", "logProxy", "Lcom/tencent/videocut/utils/log/ILogProxy;", "d", "", "tag", "", "message", "e", "t", "", "i", "setLogLevel", "setLogProxy", "iLogProxy", "v", "w", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class Logger
{
  @NotNull
  public static final Logger a = new Logger();
  private static final Logger.defaultProxy.1 b = new Logger.defaultProxy.1();
  private static int c = 2;
  private static ILogProxy d = (ILogProxy)b;
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (c > 6) {
      return;
    }
    d.a(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    if (c > 6) {
      return;
    }
    d.a(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.log.Logger
 * JD-Core Version:    0.7.0.1
 */