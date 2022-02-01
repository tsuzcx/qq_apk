package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineLifeCycleLogger;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "()V", "TAG", "", "onDestroy", "", "onFirstFrame", "onGameLaunched", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onStart", "onStop", "Triton_release"}, k=1, mv={1, 1, 16})
final class EngineLifeCycleLogger
  implements LifeCycle
{
  public static final EngineLifeCycleLogger INSTANCE = new EngineLifeCycleLogger();
  private static final String TAG = "TritonLifeCycle";
  
  public void onDestroy()
  {
    Logger.v$default("TritonLifeCycle", "onDestroy()", null, 4, null);
  }
  
  public void onFirstFrame()
  {
    Logger.v$default("TritonLifeCycle", "onFirstFrame()", null, 4, null);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameLaunched() called with: engine = ");
    localStringBuilder.append(paramTritonEngine);
    Logger.v$default("TritonLifeCycle", localStringBuilder.toString(), null, 4, null);
  }
  
  public void onStart()
  {
    Logger.v$default("TritonLifeCycle", "onStart()", null, 4, null);
  }
  
  public void onStop()
  {
    Logger.v$default("TritonLifeCycle", "onStop()", null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineLifeCycleLogger
 * JD-Core Version:    0.7.0.1
 */