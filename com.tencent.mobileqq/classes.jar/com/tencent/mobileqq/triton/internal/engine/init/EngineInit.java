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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineInit;", "", "engine", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "platformConfig", "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "soLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "(Lcom/tencent/mobileqq/triton/internal/engine/Engine;Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;Ljava/util/List;)V", "afterInitAction", "Lkotlin/Function0;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "getEngineContext", "()Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "engineContextImpl", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "engineInitStatistics", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "destroyEngineLocked", "doActionAfterInit", "action", "initEngine", "initTTApp", "launchGameLocked", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "notifyOnDestroy", "notifyOnStart", "notifyOnStop", "performLaunchGame", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EngineInit
{
  public static final EngineInit.Companion Companion = new EngineInit.Companion(null);
  private static final String TAG = "EngineInit";
  private Function0<Unit> afterInitAction;
  private final Engine engine;
  private final EngineContextImpl engineContextImpl;
  private EngineInitStatistic engineInitStatistics;
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
  
  /* Error */
  private final void doActionAfterInit(Function0<Unit> paramFunction0)
  {
    // Byte code:
    //   0: new 158	com/tencent/mobileqq/triton/internal/engine/init/EngineInit$doActionAfterInit$actionOnMainThread$1
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 161	com/tencent/mobileqq/triton/internal/engine/init/EngineInit$doActionAfterInit$actionOnMainThread$1:<init>	(Lcom/tencent/mobileqq/triton/internal/engine/init/EngineInit;Lkotlin/jvm/functions/Function0;)V
    //   9: checkcast 163	kotlin/jvm/functions/Function0
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 165	com/tencent/mobileqq/triton/internal/engine/init/EngineInit:getEngineContext	()Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;
    //   17: invokeinterface 171 1 0
    //   22: checkcast 173	java/util/concurrent/locks/Lock
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 176 1 0
    //   32: aload_0
    //   33: getfield 146	com/tencent/mobileqq/triton/internal/engine/init/EngineInit:engineInitStatistics	Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;
    //   36: ifnonnull +19 -> 55
    //   39: aload_0
    //   40: aload_2
    //   41: putfield 178	com/tencent/mobileqq/triton/internal/engine/init/EngineInit:afterInitAction	Lkotlin/jvm/functions/Function0;
    //   44: getstatic 184	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   47: astore_2
    //   48: aload_1
    //   49: invokeinterface 187 1 0
    //   54: return
    //   55: aload_2
    //   56: invokeinterface 191 1 0
    //   61: pop
    //   62: goto -18 -> 44
    //   65: astore_2
    //   66: aload_1
    //   67: invokeinterface 187 1 0
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	EngineInit
    //   0	74	1	paramFunction0	Function0<Unit>
    //   12	44	2	localObject1	Object
    //   65	8	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	44	65	finally
    //   44	48	65	finally
    //   55	62	65	finally
  }
  
  private final void initEngine()
  {
    long l = 0L;
    getEngineContext().getLifeCycleOwner().observeLifeCycle((LifeCycle)EngineLifeCycleLogger.INSTANCE);
    Lock localLock = (Lock)getEngineContext().getLock();
    localLock.lock();
    for (;;)
    {
      boolean bool;
      ErrorCodes localErrorCodes;
      try
      {
        Object localObject1 = (Throwable)null;
        try
        {
          localObject3 = new AsyncResult();
          getEngineContext().getWorkerExecutor().execute((Runnable)new EngineInit.initEngine..inlined.withLock.lambda.1((AsyncResult)localObject3, this));
          this.engineContextImpl.setScriptSystem(new ScriptSystem((EngineContext)this.engineContextImpl, (ScriptPlugin)this.engineContextImpl.getScriptPluginWrapper()));
          initTTApp();
          Logger.i$default("EngineInit", "initEngine created scriptPlugin " + localObject3, null, 4, null);
          this.engineContextImpl.getScriptPluginWrapper().init(getEngineContext(), (ScriptPlugin)((AsyncResult)localObject3).awaitResult());
          this.engineContextImpl.setEngineState(EngineState.INITIALIZED);
          if (localObject1 == null)
          {
            bool = true;
            if (localObject1 == null) {
              break label390;
            }
            localErrorCodes = ErrorCodes.UNKNOWN;
            if (!(localObject1 instanceof TritonException)) {
              break label290;
            }
            localObject1 = (TritonException)localObject1;
            break label379;
            localObject3 = ((Iterable)this.soLoadStatistics).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label320;
            }
            l += ((NativeLibraryLoadStatistic)((Iterator)localObject3).next()).getLoadTimeMs();
            continue;
          }
        }
        catch (Throwable localThrowable1)
        {
          Logger.e("EngineInit", "initEngine failure", localThrowable1);
          continue;
        }
        bool = false;
      }
      finally
      {
        localLock.unlock();
      }
      continue;
      label290:
      Object localObject3 = localThrowable2.getMessage();
      if (localObject3 != null) {}
      for (;;)
      {
        localObject2 = new TritonException((String)localObject3, localErrorCodes, localThrowable2);
        break label379;
        label320:
        this.engineInitStatistics = new EngineInitStatistic(bool, (TritonException)localObject2, l, 0L, 0L, 0L, CollectionsKt.emptyList(), this.soLoadStatistics);
        localObject2 = this.afterInitAction;
        if (localObject2 != null) {
          localObject2 = (Unit)((Function0)localObject2).invoke();
        }
        for (;;)
        {
          localLock.unlock();
          return;
        }
        label379:
        break;
        localObject3 = "";
      }
      label390:
      Object localObject2 = null;
    }
  }
  
  private final void initTTApp()
  {
    Lock localLock = (Lock)getEngineContext().getLock();
    localLock.lock();
    try
    {
      this.engineContextImpl.setTtEngine(new TTEngine(this.platformConfig, getEngineContext(), this.soLoadStatistics));
      getEngineContext().getLifeCycleOwner().observeLifeCycle((LifeCycle)new EngineInit.initTTApp..inlined.withLock.lambda.1(this));
      if (getEngineContext().getEnableCodeCache())
      {
        localObject1 = (LifeCycle)new CodeCacheSaver(this.engineContextImpl.getScriptSystem());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit
 * JD-Core Version:    0.7.0.1
 */