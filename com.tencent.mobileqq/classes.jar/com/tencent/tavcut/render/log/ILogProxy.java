package com.tencent.tavcut.render.log;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/log/ILogProxy;", "", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface ILogProxy
{
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable);
  
  public abstract void b(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void c(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void d(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void e(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.log.ILogProxy
 * JD-Core Version:    0.7.0.1
 */