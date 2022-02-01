package com.tencent.mobileqq.qqexpand.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ILog;", "", "d", "", "tag", "", "level", "", "msg", "e", "tr", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILog
{
  public abstract void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2);
  
  public abstract void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ILog
 * JD-Core Version:    0.7.0.1
 */