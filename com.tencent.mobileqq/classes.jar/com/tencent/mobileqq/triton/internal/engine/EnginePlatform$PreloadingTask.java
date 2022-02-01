package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder.Companion;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask;", "", "(Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform;)V", "engine", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "getEngine", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Triton_release"}, k=1, mv={1, 1, 16})
final class EnginePlatform$PreloadingTask
{
  @NotNull
  private final ValueHolder<Engine> engine = ValueHolder.Companion.just(null);
  
  public EnginePlatform$PreloadingTask()
  {
    EnginePlatform.access$getConfig$p(localEnginePlatform).getWorkerExecutor().execute((Runnable)new EnginePlatform.PreloadingTask.1(this));
  }
  
  @NotNull
  public final ValueHolder<Engine> getEngine()
  {
    return this.engine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatform.PreloadingTask
 * JD-Core Version:    0.7.0.1
 */