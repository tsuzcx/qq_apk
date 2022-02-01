package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.internal.engine.init.PlatformNativeLibraryLoader;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform;", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "config", "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "(Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;)V", "nativeLibraryLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "preloadingTask", "Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask;", "doCreateEngine", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "launchGame", "", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "preloadNewEngine", "PreloadingTask", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EnginePlatform
  implements TritonPlatform
{
  private final PlatformConfig config;
  private final List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics;
  private EnginePlatform.PreloadingTask preloadingTask;
  
  public EnginePlatform(@NotNull PlatformConfig paramPlatformConfig)
  {
    this.config = paramPlatformConfig;
    Logger.INSTANCE.init(this.config.getLogger());
    this.nativeLibraryLoadStatistics = PlatformNativeLibraryLoader.INSTANCE.loadEngineNativeLibrary(this.config.getEnginePackage());
    preloadNewEngine();
  }
  
  private final Engine doCreateEngine()
  {
    Engine localEngine = new Engine(this.config, this.nativeLibraryLoadStatistics);
    localEngine.observeLifeCycle((LifeCycle)new EnginePlatform.doCreateEngine..inlined.apply.lambda.1(this));
    return localEngine;
  }
  
  private final void preloadNewEngine()
  {
    try
    {
      if ((this.config.getEnablePreloadEngine()) && (this.preloadingTask == null)) {
        this.preloadingTask = new EnginePlatform.PreloadingTask(this);
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public void launchGame(@NotNull GameLaunchParam paramGameLaunchParam, @NotNull GameLaunchCallback paramGameLaunchCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchParam, "param");
    Intrinsics.checkParameterIsNotNull(paramGameLaunchCallback, "gameLaunchCallback");
    try
    {
      EnginePlatform.PreloadingTask localPreloadingTask = this.preloadingTask;
      if (localPreloadingTask != null)
      {
        this.preloadingTask = ((EnginePlatform.PreloadingTask)null);
        if (localPreloadingTask != null) {}
      }
      else
      {
        localPreloadingTask = new EnginePlatform.PreloadingTask(this);
      }
      localPreloadingTask.getEngine().observe((Function1)new EnginePlatform.launchGame.2(paramGameLaunchParam, paramGameLaunchCallback));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatform
 * JD-Core Version:    0.7.0.1
 */