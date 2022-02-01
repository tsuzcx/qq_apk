package com.tencent.mobileqq.triton.lifecycle;

import com.tencent.mobileqq.triton.TritonEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "", "onDestroy", "", "onFirstFrame", "onGameLaunched", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onStart", "onStop", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface LifeCycle
{
  public abstract void onDestroy();
  
  public abstract void onFirstFrame();
  
  public abstract void onGameLaunched(@NotNull TritonEngine paramTritonEngine);
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.lifecycle.LifeCycle
 * JD-Core Version:    0.7.0.1
 */