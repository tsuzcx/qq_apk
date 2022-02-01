package com.tencent.mobileqq.wink.edit.log;

import com.tencent.tavcut.render.log.ILogProxy;
import org.jetbrains.annotations.Nullable;

final class TavCutQLog$1
  implements ILogProxy
{
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavCutQLog.a(paramString1, paramString2);
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      paramThrowable = paramThrowable.toString();
    } else {
      paramThrowable = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable);
    TavCutQLog.d(paramString1, localStringBuilder.toString());
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavCutQLog.a(paramString1, paramString2);
  }
  
  public void c(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavCutQLog.b(paramString1, paramString2);
  }
  
  public void d(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavCutQLog.c(paramString1, paramString2);
  }
  
  public void e(@Nullable String paramString1, @Nullable String paramString2)
  {
    TavCutQLog.d(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.log.TavCutQLog.1
 * JD-Core Version:    0.7.0.1
 */