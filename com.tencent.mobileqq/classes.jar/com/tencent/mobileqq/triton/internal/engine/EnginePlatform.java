package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.internal.engine.init.PlatformNativeLibraryLoader;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
  
  /* Error */
  public void launchGame(@NotNull com.tencent.mobileqq.triton.engine.GameLaunchParam paramGameLaunchParam, @NotNull com.tencent.mobileqq.triton.engine.GameLaunchCallback paramGameLaunchCallback)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 128
    //   3: invokestatic 48	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 129
    //   9: invokestatic 48	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 118	com/tencent/mobileqq/triton/internal/engine/EnginePlatform:preloadingTask	Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +37 -> 57
    //   23: aload_0
    //   24: aconst_null
    //   25: checkcast 120	com/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask
    //   28: putfield 118	com/tencent/mobileqq/triton/internal/engine/EnginePlatform:preloadingTask	Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask;
    //   31: aload_3
    //   32: ifnull +25 -> 57
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: invokevirtual 133	com/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask:getEngine	()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;
    //   41: new 135	com/tencent/mobileqq/triton/internal/engine/EnginePlatform$launchGame$2
    //   44: dup
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 137	com/tencent/mobileqq/triton/internal/engine/EnginePlatform$launchGame$2:<init>	(Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;)V
    //   50: checkcast 139	kotlin/jvm/functions/Function1
    //   53: invokevirtual 145	com/tencent/mobileqq/triton/internal/lifecycle/ValueHolder:observe	(Lkotlin/jvm/functions/Function1;)V
    //   56: return
    //   57: new 120	com/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 121	com/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask:<init>	(Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform;)V
    //   65: astore_3
    //   66: goto -31 -> 35
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	EnginePlatform
    //   0	74	1	paramGameLaunchParam	com.tencent.mobileqq.triton.engine.GameLaunchParam
    //   0	74	2	paramGameLaunchCallback	com.tencent.mobileqq.triton.engine.GameLaunchCallback
    //   18	48	3	localPreloadingTask	EnginePlatform.PreloadingTask
    // Exception table:
    //   from	to	target	type
    //   14	19	69	finally
    //   23	31	69	finally
    //   57	66	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatform
 * JD-Core Version:    0.7.0.1
 */