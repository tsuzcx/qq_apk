package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "", "onError", "", "message", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "onScriptError", "stack", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ErrorCallback
{
  public abstract void onError(@NotNull String paramString, @NotNull TritonException paramTritonException);
  
  public abstract void onScriptError(@NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.ErrorCallback
 * JD-Core Version:    0.7.0.1
 */