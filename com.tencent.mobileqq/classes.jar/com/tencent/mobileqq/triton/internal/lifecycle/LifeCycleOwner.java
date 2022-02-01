package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "", "engineState", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "observeLifeCycle", "", "lifeCycle", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "removeLifeCycleObserver", "Triton_release"}, k=1, mv={1, 1, 16})
public abstract interface LifeCycleOwner
{
  @Nullable
  public abstract EngineState getEngineState();
  
  public abstract void observeLifeCycle(@NotNull LifeCycle paramLifeCycle);
  
  public abstract void removeLifeCycleObserver(@NotNull LifeCycle paramLifeCycle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner
 * JD-Core Version:    0.7.0.1
 */