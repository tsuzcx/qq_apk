package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/engine/EnginePlatform$doCreateEngine$1$1", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onFirstFrame", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EnginePlatform$doCreateEngine$$inlined$apply$lambda$1
  implements LifeCycle
{
  EnginePlatform$doCreateEngine$$inlined$apply$lambda$1(EnginePlatform paramEnginePlatform) {}
  
  public void onDestroy()
  {
    LifeCycle.DefaultImpls.onDestroy(this);
  }
  
  public void onFirstFrame()
  {
    EnginePlatform.access$preloadNewEngine(this.this$0);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    LifeCycle.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    LifeCycle.DefaultImpls.onStart(this);
  }
  
  public void onStop()
  {
    LifeCycle.DefaultImpls.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatform.doCreateEngine..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */