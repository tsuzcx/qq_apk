package com.tencent.mobileqq.triton.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "", "printConsoleLog", "", "level", "Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;", "tag", "", "message", "throwable", "", "printLog", "Level", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface LogDelegate
{
  public abstract void printConsoleLog(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable);
  
  public abstract void printLog(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.LogDelegate
 * JD-Core Version:    0.7.0.1
 */