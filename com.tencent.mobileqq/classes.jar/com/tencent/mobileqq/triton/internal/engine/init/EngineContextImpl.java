package com.tencent.mobileqq.triton.internal.engine.init;

import android.content.Context;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.EngineContext.DefaultImpls;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "context", "Landroid/content/Context;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "enableOpenGlEs3", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "(Landroid/content/Context;Lcom/tencent/mobileqq/triton/model/DebugConfig;Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;ZZLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/utils/Downloader;)V", "_ttEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "get_ttEngine", "()Lcom/tencent/mobileqq/triton/engine/TTEngine;", "set_ttEngine", "(Lcom/tencent/mobileqq/triton/engine/TTEngine;)V", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "setDataFileSystem", "(Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;)V", "getDebugConfig", "()Lcom/tencent/mobileqq/triton/model/DebugConfig;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "getEnableCodeCache", "()Z", "getEnableOpenGlEs3", "engineData", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineDataImpl;", "getEngineData", "()Lcom/tencent/mobileqq/triton/internal/engine/init/EngineDataImpl;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "value", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "engineState", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "setEngineState", "(Lcom/tencent/mobileqq/triton/engine/EngineState;)V", "fontBitmapManager", "Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "getFontBitmapManager", "()Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "setGamePackage", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;)V", "gameThreadExecutor", "getGameThreadExecutor", "()Ljava/util/concurrent/Executor;", "gameThreadExecutor$delegate", "Lkotlin/Lazy;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "setGameView", "(Lcom/tencent/mobileqq/triton/view/GameView;)V", "id", "", "getId", "()I", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "setInspectorAgent", "(Lcom/tencent/mobileqq/triton/script/InspectorAgent;)V", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/engine/init/LifeCycleOwnerImpl;", "getLifeCycleOwner", "()Lcom/tencent/mobileqq/triton/internal/engine/init/LifeCycleOwnerImpl;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "getMainThreadExecutor", "screenShotCallbackHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "getScreenShotCallbackHolder", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "scriptPluginWrapper", "Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptPluginWrapper;", "getScriptPluginWrapper", "()Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptPluginWrapper;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "getScriptSystem", "()Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "setScriptSystem", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;)V", "statisticsManager", "Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "ttEngine", "getTtEngine", "setTtEngine", "getWorkerExecutor", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
final class EngineContextImpl
  implements EngineContext
{
  public static final EngineContextImpl.Companion Companion = new EngineContextImpl.Companion(null);
  private static final AtomicInteger engineIdCounter = new AtomicInteger();
  @Nullable
  private TTEngine _ttEngine;
  @NotNull
  private final Context context;
  @NotNull
  public GameDataFileSystem dataFileSystem;
  @NotNull
  private final DebugConfig debugConfig;
  @NotNull
  private final Downloader downloader;
  private final boolean enableCodeCache;
  private final boolean enableOpenGlEs3;
  @NotNull
  private final EngineDataImpl engineData;
  @NotNull
  private final EnginePackage enginePackage;
  @NotNull
  private final FontBitmapManager fontBitmapManager;
  @NotNull
  public GamePackage gamePackage;
  @NotNull
  private final Lazy gameThreadExecutor$delegate;
  @NotNull
  public GameView gameView;
  private final int id;
  @Nullable
  private InspectorAgent inspectorAgent;
  @NotNull
  private final LifeCycleOwnerImpl lifeCycleOwner;
  @NotNull
  private final ReentrantLock lock;
  @NotNull
  private final Executor mainThreadExecutor;
  @NotNull
  private final ValueHolder<ScreenShotCallback> screenShotCallbackHolder;
  @NotNull
  private final ScriptPluginWrapper scriptPluginWrapper;
  @NotNull
  public ScriptSystem scriptSystem;
  @NotNull
  private final StatisticsManagerImpl statisticsManager;
  @NotNull
  private final Executor workerExecutor;
  
  public EngineContextImpl(@NotNull Context paramContext, @NotNull DebugConfig paramDebugConfig, @NotNull EnginePackage paramEnginePackage, boolean paramBoolean1, boolean paramBoolean2, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull Downloader paramDownloader)
  {
    this.context = paramContext;
    this.debugConfig = paramDebugConfig;
    this.enginePackage = paramEnginePackage;
    this.enableCodeCache = paramBoolean1;
    this.enableOpenGlEs3 = paramBoolean2;
    this.workerExecutor = paramExecutor1;
    this.mainThreadExecutor = paramExecutor2;
    this.downloader = paramDownloader;
    this.lock = new ReentrantLock();
    this.id = engineIdCounter.incrementAndGet();
    this.scriptPluginWrapper = new ScriptPluginWrapper();
    this.engineData = new EngineDataImpl(this);
    this.lifeCycleOwner = new LifeCycleOwnerImpl();
    this.fontBitmapManager = new FontBitmapManager();
    this.statisticsManager = new StatisticsManagerImpl((LifeCycleOwner)getLifeCycleOwner(), (Lock)getLock());
    this.screenShotCallbackHolder = new ValueHolder(null, (LifeCycleOwner)getLifeCycleOwner(), (Lock)getLock());
    this.gameThreadExecutor$delegate = LazyKt.lazy((Function0)new EngineContextImpl.gameThreadExecutor.2(this));
  }
  
  @NotNull
  public Context getContext()
  {
    return this.context;
  }
  
  @NotNull
  public GameDataFileSystem getDataFileSystem()
  {
    GameDataFileSystem localGameDataFileSystem = this.dataFileSystem;
    if (localGameDataFileSystem == null) {
      Intrinsics.throwUninitializedPropertyAccessException("dataFileSystem");
    }
    return localGameDataFileSystem;
  }
  
  @NotNull
  public DebugConfig getDebugConfig()
  {
    return this.debugConfig;
  }
  
  @NotNull
  public Downloader getDownloader()
  {
    return this.downloader;
  }
  
  public boolean getEnableCodeCache()
  {
    return this.enableCodeCache;
  }
  
  public boolean getEnableOpenGlEs3()
  {
    return this.enableOpenGlEs3;
  }
  
  @NotNull
  public EngineDataImpl getEngineData()
  {
    return this.engineData;
  }
  
  @NotNull
  public EnginePackage getEnginePackage()
  {
    return this.enginePackage;
  }
  
  @Nullable
  public EngineState getEngineState()
  {
    return getLifeCycleOwner().getEngineState();
  }
  
  @NotNull
  public FontBitmapManager getFontBitmapManager()
  {
    return this.fontBitmapManager;
  }
  
  @NotNull
  public GamePackage getGamePackage()
  {
    GamePackage localGamePackage = this.gamePackage;
    if (localGamePackage == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gamePackage");
    }
    return localGamePackage;
  }
  
  @NotNull
  public Executor getGameThreadExecutor()
  {
    return (Executor)this.gameThreadExecutor$delegate.getValue();
  }
  
  @NotNull
  public GameView getGameView()
  {
    GameView localGameView = this.gameView;
    if (localGameView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gameView");
    }
    return localGameView;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  @Nullable
  public final InspectorAgent getInspectorAgent()
  {
    return this.inspectorAgent;
  }
  
  @NotNull
  public LifeCycleOwnerImpl getLifeCycleOwner()
  {
    return this.lifeCycleOwner;
  }
  
  @NotNull
  public ReentrantLock getLock()
  {
    return this.lock;
  }
  
  @NotNull
  public Executor getMainThreadExecutor()
  {
    return this.mainThreadExecutor;
  }
  
  @NotNull
  public ValueHolder<ScreenShotCallback> getScreenShotCallbackHolder()
  {
    return this.screenShotCallbackHolder;
  }
  
  @NotNull
  public final ScriptPluginWrapper getScriptPluginWrapper()
  {
    return this.scriptPluginWrapper;
  }
  
  @NotNull
  public ScriptSystem getScriptSystem()
  {
    ScriptSystem localScriptSystem = this.scriptSystem;
    if (localScriptSystem == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scriptSystem");
    }
    return localScriptSystem;
  }
  
  @NotNull
  public StatisticsManagerImpl getStatisticsManager()
  {
    return this.statisticsManager;
  }
  
  @NotNull
  public TTEngine getTtEngine()
  {
    TTEngine localTTEngine = this._ttEngine;
    if (localTTEngine == null) {
      Intrinsics.throwNpe();
    }
    return localTTEngine;
  }
  
  @NotNull
  public Executor getWorkerExecutor()
  {
    return this.workerExecutor;
  }
  
  @Nullable
  public final TTEngine get_ttEngine()
  {
    return this._ttEngine;
  }
  
  public boolean isAlive()
  {
    return EngineContext.DefaultImpls.isAlive(this);
  }
  
  public void setDataFileSystem(@NotNull GameDataFileSystem paramGameDataFileSystem)
  {
    Intrinsics.checkParameterIsNotNull(paramGameDataFileSystem, "<set-?>");
    this.dataFileSystem = paramGameDataFileSystem;
  }
  
  public void setEngineState(@Nullable EngineState paramEngineState)
  {
    getLifeCycleOwner().setEngineState(paramEngineState);
  }
  
  public void setGamePackage(@NotNull GamePackage paramGamePackage)
  {
    Intrinsics.checkParameterIsNotNull(paramGamePackage, "<set-?>");
    this.gamePackage = paramGamePackage;
  }
  
  public void setGameView(@NotNull GameView paramGameView)
  {
    Intrinsics.checkParameterIsNotNull(paramGameView, "<set-?>");
    this.gameView = paramGameView;
  }
  
  public final void setInspectorAgent(@Nullable InspectorAgent paramInspectorAgent)
  {
    this.inspectorAgent = paramInspectorAgent;
  }
  
  public void setScriptSystem(@NotNull ScriptSystem paramScriptSystem)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptSystem, "<set-?>");
    this.scriptSystem = paramScriptSystem;
  }
  
  public void setTtEngine(@NotNull TTEngine paramTTEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTTEngine, "value");
    this._ttEngine = paramTTEngine;
  }
  
  public final void set_ttEngine(@Nullable TTEngine paramTTEngine)
  {
    this._ttEngine = paramTTEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineContextImpl
 * JD-Core Version:    0.7.0.1
 */