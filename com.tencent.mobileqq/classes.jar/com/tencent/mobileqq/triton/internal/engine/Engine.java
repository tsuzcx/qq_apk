package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.internal.engine.init.EngineInit;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import java.util.List;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "Lcom/tencent/mobileqq/triton/TritonEngine;", "platformConfig", "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "soLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "(Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;Ljava/util/List;)V", "context", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "getContext$Triton_release", "()Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "data", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "getData", "()Lcom/tencent/mobileqq/triton/engine/EngineData;", "engineInit", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineInit;", "state", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "statisticsManager", "Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "destroy", "", "launchGame", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "observeLifeCycle", "lifeCycle", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "removeLifeCycleObserver", "start", "stop", "takeScreenShot", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "toString", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class Engine
  implements TritonEngine
{
  @NotNull
  private final EngineContext context;
  private final EngineInit engineInit;
  
  public Engine(@NotNull PlatformConfig paramPlatformConfig, @NotNull List<NativeLibraryLoadStatistic> paramList)
  {
    this.engineInit = new EngineInit(this, paramPlatformConfig, paramList);
    this.context = this.engineInit.getEngineContext();
  }
  
  public void destroy()
  {
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      if (getState() != EngineState.DESTROYED)
      {
        this.context.setEngineState(EngineState.DESTROYED);
        this.engineInit.notifyOnDestroy();
        this.engineInit.destroyEngineLocked();
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  public final EngineContext getContext$Triton_release()
  {
    return this.context;
  }
  
  @NotNull
  public EngineData getData()
  {
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      EngineData localEngineData = this.context.getEngineData();
      return localEngineData;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  public EngineState getState()
  {
    EngineState localEngineState = this.context.getEngineState();
    if (localEngineState != null) {
      return localEngineState;
    }
    throw ((Throwable)new IllegalStateException("engine is initializing"));
  }
  
  @NotNull
  public StatisticsManager getStatisticsManager()
  {
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      StatisticsManagerImpl localStatisticsManagerImpl = this.context.getStatisticsManager();
      return (StatisticsManager)localStatisticsManagerImpl;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void launchGame(@NotNull GameLaunchParam paramGameLaunchParam, @NotNull GameLaunchCallback paramGameLaunchCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchParam, "param");
    Intrinsics.checkParameterIsNotNull(paramGameLaunchCallback, "gameLaunchCallback");
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      EngineState localEngineState = this.context.getEngineState();
      if (localEngineState != null)
      {
        int i = Engine.WhenMappings.$EnumSwitchMapping$0[localEngineState.ordinal()];
        if (i != 1)
        {
          if (i == 2) {
            throw ((Throwable)new IllegalStateException("engine is destroyed"));
          }
        }
        else
        {
          this.engineInit.launchGameLocked(paramGameLaunchParam, paramGameLaunchCallback);
          paramGameLaunchParam = Unit.INSTANCE;
          return;
        }
      }
      throw ((Throwable)new IllegalStateException("already launched"));
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void observeLifeCycle(@NotNull LifeCycle paramLifeCycle)
  {
    Intrinsics.checkParameterIsNotNull(paramLifeCycle, "lifeCycle");
    this.context.getLifeCycleOwner().observeLifeCycle(paramLifeCycle);
  }
  
  public void removeLifeCycleObserver(@NotNull LifeCycle paramLifeCycle)
  {
    Intrinsics.checkParameterIsNotNull(paramLifeCycle, "lifeCycle");
    this.context.getLifeCycleOwner().removeLifeCycleObserver(paramLifeCycle);
  }
  
  public void start()
  {
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      if (getState() == EngineState.STOPPED)
      {
        this.context.setEngineState(EngineState.STARTED);
        this.engineInit.notifyOnStart();
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void stop()
  {
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      if (getState() == EngineState.STARTED)
      {
        this.context.setEngineState(EngineState.STOPPED);
        this.engineInit.notifyOnStop();
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void takeScreenShot(@NotNull ScreenShotCallback paramScreenShotCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramScreenShotCallback, "callback");
    Lock localLock = (Lock)this.context.getLock();
    localLock.lock();
    try
    {
      this.context.getScreenShotCallbackHolder().setValue(paramScreenShotCallback);
      paramScreenShotCallback = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" [");
    localStringBuilder.append(this.context.getId());
    localStringBuilder.append("] (name=");
    localStringBuilder.append(this.context.getGamePackage().getName());
    localStringBuilder.append(", ");
    localStringBuilder.append("appId=");
    localStringBuilder.append(this.context.getGamePackage().getId());
    localStringBuilder.append(", ");
    localStringBuilder.append("enginePackageVersion=");
    localStringBuilder.append(this.context.getEnginePackage().getVersion());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.Engine
 * JD-Core Version:    0.7.0.1
 */