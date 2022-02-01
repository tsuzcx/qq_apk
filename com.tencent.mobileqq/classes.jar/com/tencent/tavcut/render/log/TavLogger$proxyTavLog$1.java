package com.tencent.tavcut.render.log;

import com.tencent.tav.decoder.logger.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/log/TavLogger$proxyTavLog$1", "Lcom/tencent/tav/decoder/logger/ILog;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TavLogger$proxyTavLog$1
  implements ILog
{
  public void d(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavLogger.b(paramString1, paramString2);
  }
  
  public void e(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavLogger.e(paramString1, paramString2);
  }
  
  public void e(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    TavLogger.a(paramString1, paramString2, paramThrowable);
  }
  
  public void i(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavLogger.c(paramString1, paramString2);
  }
  
  public void v(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavLogger.a(paramString1, paramString2);
  }
  
  public void w(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavLogger.d(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.log.TavLogger.proxyTavLog.1
 * JD-Core Version:    0.7.0.1
 */