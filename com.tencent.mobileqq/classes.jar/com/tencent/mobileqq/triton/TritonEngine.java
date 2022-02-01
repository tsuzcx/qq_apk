package com.tencent.mobileqq.triton;

import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/TritonEngine;", "", "data", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "getData", "()Lcom/tencent/mobileqq/triton/engine/EngineData;", "state", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "statisticsManager", "Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "destroy", "", "observeLifeCycle", "lifeCycle", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "removeLifeCycleObserver", "start", "stop", "takeScreenShot", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface TritonEngine
{
  public abstract void destroy();
  
  @NotNull
  public abstract EngineData getData();
  
  @NotNull
  public abstract EngineState getState();
  
  @NotNull
  public abstract StatisticsManager getStatisticsManager();
  
  public abstract void observeLifeCycle(@NotNull LifeCycle paramLifeCycle);
  
  public abstract void removeLifeCycleObserver(@NotNull LifeCycle paramLifeCycle);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void takeScreenShot(@NotNull ScreenShotCallback paramScreenShotCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.TritonEngine
 * JD-Core Version:    0.7.0.1
 */