package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/LifeCycleOwnerImpl;", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "()V", "engineState", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "setEngineState", "(Lcom/tencent/mobileqq/triton/engine/EngineState;)V", "lifeCycles", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "notifyOnDestroy", "", "notifyOnFirstFrame", "notifyOnGameLaunched", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "notifyOnStart", "notifyOnStop", "observeLifeCycle", "lifeCycle", "removeLifeCycleObserver", "Triton_release"}, k=1, mv={1, 1, 16})
final class LifeCycleOwnerImpl
  implements LifeCycleOwner
{
  @Nullable
  private EngineState engineState;
  private final CopyOnWriteArrayList<LifeCycle> lifeCycles = new CopyOnWriteArrayList();
  
  @Nullable
  public EngineState getEngineState()
  {
    return this.engineState;
  }
  
  public final void notifyOnDestroy()
  {
    Iterator localIterator = ((Iterable)this.lifeCycles).iterator();
    while (localIterator.hasNext()) {
      ((LifeCycle)localIterator.next()).onDestroy();
    }
  }
  
  public final void notifyOnFirstFrame()
  {
    Iterator localIterator = ((Iterable)this.lifeCycles).iterator();
    while (localIterator.hasNext()) {
      ((LifeCycle)localIterator.next()).onFirstFrame();
    }
  }
  
  public final void notifyOnGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    Iterator localIterator = ((Iterable)this.lifeCycles).iterator();
    while (localIterator.hasNext()) {
      ((LifeCycle)localIterator.next()).onGameLaunched(paramTritonEngine);
    }
  }
  
  public final void notifyOnStart()
  {
    Iterator localIterator = ((Iterable)this.lifeCycles).iterator();
    while (localIterator.hasNext()) {
      ((LifeCycle)localIterator.next()).onStart();
    }
  }
  
  public final void notifyOnStop()
  {
    Iterator localIterator = ((Iterable)this.lifeCycles).iterator();
    while (localIterator.hasNext()) {
      ((LifeCycle)localIterator.next()).onStop();
    }
  }
  
  public void observeLifeCycle(@NotNull LifeCycle paramLifeCycle)
  {
    Intrinsics.checkParameterIsNotNull(paramLifeCycle, "lifeCycle");
    this.lifeCycles.add(paramLifeCycle);
  }
  
  public void removeLifeCycleObserver(@NotNull LifeCycle paramLifeCycle)
  {
    Intrinsics.checkParameterIsNotNull(paramLifeCycle, "lifeCycle");
    this.lifeCycles.remove(paramLifeCycle);
  }
  
  public void setEngineState(@Nullable EngineState paramEngineState)
  {
    this.engineState = paramEngineState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.LifeCycleOwnerImpl
 * JD-Core Version:    0.7.0.1
 */