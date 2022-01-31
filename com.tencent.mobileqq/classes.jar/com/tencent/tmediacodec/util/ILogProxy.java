package com.tencent.tmediacodec.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/util/ILogProxy;", "", "d", "", "tag", "", "msg", "e", "tr", "", "i", "v", "w", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface ILogProxy
{
  public abstract void d(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void e(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable);
  
  public abstract void i(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void v(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void w(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ILogProxy
 * JD-Core Version:    0.7.0.1
 */