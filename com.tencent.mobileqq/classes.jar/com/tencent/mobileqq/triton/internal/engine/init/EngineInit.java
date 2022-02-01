package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.internal.engine.Engine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.script.CodeCacheSaver;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.utils.AsyncResult;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineInit;", "", "engine", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "platformConfig", "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "soLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "(Lcom/tencent/mobileqq/triton/internal/engine/Engine;Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;Ljava/util/List;)V", "afterInitAction", "Lkotlin/Function0;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "getEngineContext", "()Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "engineContextImpl", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "engineInitStatistics", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "mCodeCacheSaver", "Lcom/tencent/mobileqq/triton/internal/script/CodeCacheSaver;", "destroyEngineLocked", "doActionAfterInit", "action", "initEngine", "initTTApp", "launchGameLocked", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "notifyOnDestroy", "notifyOnStart", "notifyOnStop", "performLaunchGame", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EngineInit
{
  public static final EngineInit.Companion Companion = new EngineInit.Companion(null);
  private static final String TAG = "EngineInit";
  private Function0<Unit> afterInitAction;
  private final Engine engine;
  private final EngineContextImpl engineContextImpl;
  private EngineInitStatistic engineInitStatistics;
  private CodeCacheSaver mCodeCacheSaver;
  private final PlatformConfig platformConfig;
  private final List<NativeLibraryLoadStatistic> soLoadStatistics;
  
  public EngineInit(@NotNull Engine paramEngine, @NotNull PlatformConfig paramPlatformConfig, @NotNull List<NativeLibraryLoadStatistic> paramList)
  {
    this.engine = paramEngine;
    this.platformConfig = paramPlatformConfig;
    this.soLoadStatistics = paramList;
    this.engineContextImpl = new EngineContextImpl(this.platformConfig.getContext(), this.platformConfig.getDebugConfig(), Utils.decorate(this.platformConfig.getEnginePackage(), this.platformConfig.getEnableCodeCache()), this.platformConfig.getEnableCodeCache(), this.platformConfig.getEnableOpenGlEs3(), this.platformConfig.getWorkerExecutor(), this.platformConfig.getMainThreadExecutor(), this.platformConfig.getDownloader());
    initEngine();
  }
  
  private final void doActionAfterInit(Function0<Unit> paramFunction0)
  {
    Object localObject1 = (Function0)new EngineInit.doActionAfterInit.actionOnMainThread.1(this, paramFunction0);
    paramFunction0 = (Lock)getEngineContext().getLock();
    paramFunction0.lock();
    try
    {
      if (this.engineInitStatistics == null) {
        this.afterInitAction = ((Function0)localObject1);
      } else {
        ((Function0)localObject1).invoke();
      }
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramFunction0.unlock();
    }
  }
  
  private final void initEngine()
  {
    getEngineContext().getLifeCycleOwner().observeLifeCycle((LifeCycle)EngineLifeCycleLogger.INSTANCE);
    localLock = (Lock)getEngineContext().getLock();
    localLock.lock();
    Object localObject1 = null;
    try
    {
      Throwable localThrowable1 = (Throwable)null;
      try
      {
        localObject3 = new AsyncResult();
        getEngineContext().getWorkerExecutor().execute((Runnable)new EngineInit.initEngine..inlined.withLock.lambda.1((AsyncResult)localObject3, this));
        this.engineContextImpl.setScriptSystem(new ScriptSystem((EngineContext)this.engineContextImpl, (ScriptPlugin)this.engineContextImpl.getScriptPluginWrapper()));
        initTTApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initEngine created scriptPlugin ");
        localStringBuilder.append(localObject3);
        Logger.i$default("EngineInit", localStringBuilder.toString(), null, 4, null);
        this.engineContextImpl.getScriptPluginWrapper().init(getEngineContext(), (ScriptPlugin)((AsyncResult)localObject3).awaitResult());
      }
      catch (Throwable localThrowable2)
      {
        Logger.e("EngineInit", "initEngine failure", localThrowable2);
      }
      this.engineContextImpl.setEngineState(EngineState.INITIALIZED);
      if (localThrowable2 != null) {
        break label393;
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        Object localObject3;
        Iterator localIterator;
        long l;
        localLock.unlock();
        for (;;)
        {
          throw localObject2;
        }
        boolean bool = false;
        continue;
        String str = "";
      }
    }
    if (localThrowable2 != null)
    {
      localObject3 = ErrorCodes.UNKNOWN;
      if ((localThrowable2 instanceof TritonException))
      {
        localObject1 = (TritonException)localThrowable2;
      }
      else
      {
        localObject1 = localThrowable2.getMessage();
        if (localObject1 == null) {
          break label398;
        }
        localObject1 = new TritonException((String)localObject1, (ErrorCodes)localObject3, localThrowable2);
      }
    }
    localIterator = ((Iterable)this.soLoadStatistics).iterator();
    for (l = 0L; localIterator.hasNext(); l += ((NativeLibraryLoadStatistic)localIterator.next()).getLoadTimeMs()) {}
    this.engineInitStatistics = new EngineInitStatistic(bool, (TritonException)localObject1, l, 0L, 0L, 0L, CollectionsKt.emptyList(), this.soLoadStatistics);
    localObject1 = this.afterInitAction;
    if (localObject1 != null) {
      localObject1 = (Unit)((Function0)localObject1).invoke();
    }
    localLock.unlock();
  }
  
  private final void initTTApp()
  {
    Lock localLock = (Lock)getEngineContext().getLock();
    localLock.lock();
    try
    {
      this.engineContextImpl.setTtEngine(new TTEngine(this.platformConfig, getEngineContext(), this.soLoadStatistics));
      getEngineContext().getLifeCycleOwner().observeLifeCycle((LifeCycle)new EngineInit.initTTApp..inlined.withLock.lambda.1(this));
      this.mCodeCacheSaver = new CodeCacheSaver(this.engineContextImpl.getScriptSystem(), this.engineContextImpl.getEnginePackage());
      if (getEngineContext().getEnableCodeCache())
      {
        localObject1 = this.mCodeCacheSaver;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mCodeCacheSaver");
        }
        ((CodeCacheSaver)localObject1).scheduleAutoSaving();
        localObject1 = this.mCodeCacheSaver;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mCodeCacheSaver");
        }
        localObject1 = (LifeCycle)localObject1;
        getEngineContext().getLifeCycleOwner().observeLifeCycle((LifeCycle)localObject1);
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private final void performLaunchGame(GameLaunchParam paramGameLaunchParam, GameLaunchCallback paramGameLaunchCallback)
  {
    CodeCacheSaver localCodeCacheSaver = this.mCodeCacheSaver;
    if (localCodeCacheSaver == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCodeCacheSaver");
    }
    localCodeCacheSaver.cancelAutoSaving();
    this.engineContextImpl.setGamePackage(Utils.decorate(paramGameLaunchParam.getGamePackage(), this.platformConfig.getEnableCodeCache()));
    this.engineContextImpl.setDataFileSystem(paramGameLaunchParam.getDataFileSystem());
    this.engineContextImpl.setGameView(paramGameLaunchParam.getGameView());
    this.engineContextImpl.setInspectorAgent(paramGameLaunchParam.getInspectorAgent());
    this.engineContextImpl.getStatisticsManager().getJankTraceLevelHolder().setValue(paramGameLaunchParam.getJankTraceLevel());
    this.engineContextImpl.getEngineData().getUserDataMap().putAll(paramGameLaunchParam.getUserData());
    this.engineContextImpl.getTtEngine().getGameLauncher().launchGame(paramGameLaunchParam, (GameLaunchCallback)new EngineInit.performLaunchGame.1(this, paramGameLaunchCallback), (Function0)new EngineInit.performLaunchGame.2(this));
  }
  
  public final void destroyEngineLocked()
  {
    TTEngine localTTEngine = this.engineContextImpl.get_ttEngine();
    if (localTTEngine != null) {
      localTTEngine.onDestroy();
    }
  }
  
  @NotNull
  public final EngineContext getEngineContext()
  {
    return (EngineContext)this.engineContextImpl;
  }
  
  public final void launchGameLocked(@NotNull GameLaunchParam paramGameLaunchParam, @NotNull GameLaunchCallback paramGameLaunchCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchParam, "param");
    Intrinsics.checkParameterIsNotNull(paramGameLaunchCallback, "gameLaunchCallback");
    doActionAfterInit((Function0)new EngineInit.launchGameLocked.1(this, paramGameLaunchCallback, Utils.timeStamp(), paramGameLaunchParam));
  }
  
  public final void notifyOnDestroy()
  {
    this.engineContextImpl.getLifeCycleOwner().notifyOnDestroy();
  }
  
  public final void notifyOnStart()
  {
    this.engineContextImpl.getLifeCycleOwner().notifyOnStart();
  }
  
  public final void notifyOnStop()
  {
    this.engineContextImpl.getLifeCycleOwner().notifyOnStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit
 * JD-Core Version:    0.7.0.1
 */