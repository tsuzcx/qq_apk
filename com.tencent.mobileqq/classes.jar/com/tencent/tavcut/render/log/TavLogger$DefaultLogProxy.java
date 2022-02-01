package com.tencent.tavcut.render.log;

import android.util.Log;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/log/TavLogger$DefaultLogProxy;", "Lcom/tencent/tavcut/render/log/ILogProxy;", "()V", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
final class TavLogger$DefaultLogProxy
  implements ILogProxy
{
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void c(@Nullable String paramString1, @Nullable String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void d(@Nullable String paramString1, @Nullable String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void e(@Nullable String paramString1, @Nullable String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.log.TavLogger.DefaultLogProxy
 * JD-Core Version:    0.7.0.1
 */