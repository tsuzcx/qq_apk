package com.tencent.mobileqq.triton.lifecycle;

import com.tencent.mobileqq.triton.TritonEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class LifeCycle$DefaultImpls
{
  public static void onDestroy(LifeCycle paramLifeCycle) {}
  
  public static void onFirstFrame(LifeCycle paramLifeCycle) {}
  
  public static void onGameLaunched(LifeCycle paramLifeCycle, @NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
  }
  
  public static void onStart(LifeCycle paramLifeCycle) {}
  
  public static void onStop(LifeCycle paramLifeCycle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */