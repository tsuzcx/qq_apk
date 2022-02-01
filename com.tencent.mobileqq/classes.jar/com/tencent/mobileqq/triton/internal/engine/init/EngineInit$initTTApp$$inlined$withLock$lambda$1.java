package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/engine/init/EngineInit$initTTApp$1$1", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onStart", "", "onStop", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EngineInit$initTTApp$$inlined$withLock$lambda$1
  implements LifeCycle
{
  EngineInit$initTTApp$$inlined$withLock$lambda$1(EngineInit paramEngineInit) {}
  
  public void onDestroy()
  {
    LifeCycle.DefaultImpls.onDestroy(this);
  }
  
  public void onFirstFrame()
  {
    LifeCycle.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    LifeCycle.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    EngineInit.access$getEngineContextImpl$p(this.this$0).getTtEngine().onResume();
  }
  
  public void onStop()
  {
    EngineInit.access$getEngineContextImpl$p(this.this$0).getTtEngine().onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.initTTApp..inlined.withLock.lambda.1
 * JD-Core Version:    0.7.0.1
 */