package com.tencent.mobileqq.triton.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "", "onFail", "", "errorMsg", "", "onProgress", "totalBytes", "", "currentBytes", "onSuccess", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface Downloader$Listener
{
  public abstract void onFail(@NotNull String paramString);
  
  public abstract void onProgress(long paramLong1, long paramLong2);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.Downloader.Listener
 * JD-Core Version:    0.7.0.1
 */