package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/lifecycle/ValueHolder$1", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onDestroy", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ValueHolder$1
  implements LifeCycle
{
  public void onDestroy()
  {
    ValueHolder.access$getObservers$p(this.this$0).clear();
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
    LifeCycle.DefaultImpls.onStart(this);
  }
  
  public void onStop()
  {
    LifeCycle.DefaultImpls.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder.1
 * JD-Core Version:    0.7.0.1
 */