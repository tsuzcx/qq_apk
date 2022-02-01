package com.tencent.mobileqq.triton.filesystem;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "", "onComplete", "", "result", "Lkotlin/Result;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Ljava/lang/Object;)V", "onProgress", "totalBytes", "", "currentBytes", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GamePackage$SubpackageListener
{
  public abstract void onComplete(@NotNull Object paramObject);
  
  public abstract void onProgress(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener
 * JD-Core Version:    0.7.0.1
 */