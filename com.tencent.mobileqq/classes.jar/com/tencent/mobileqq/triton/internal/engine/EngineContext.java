package com.tencent.mobileqq.triton.internal.engine;

import android.content.Context;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "getDebugConfig", "()Lcom/tencent/mobileqq/triton/model/DebugConfig;", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "enableCodeCache", "", "getEnableCodeCache", "()Z", "enableOpenGlEs3", "getEnableOpenGlEs3", "engineData", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "getEngineData", "()Lcom/tencent/mobileqq/triton/engine/EngineData;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "engineState", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "setEngineState", "(Lcom/tencent/mobileqq/triton/engine/EngineState;)V", "fontBitmapManager", "Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "getFontBitmapManager", "()Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "gameThreadExecutor", "Ljava/util/concurrent/Executor;", "getGameThreadExecutor", "()Ljava/util/concurrent/Executor;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "id", "", "getId", "()I", "isAlive", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "getLifeCycleOwner", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "mainThreadExecutor", "getMainThreadExecutor", "screenShotCallbackHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "getScreenShotCallbackHolder", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "getScriptSystem", "()Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "statisticsManager", "Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "ttEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "getTtEngine", "()Lcom/tencent/mobileqq/triton/engine/TTEngine;", "workerExecutor", "getWorkerExecutor", "Triton_release"}, k=1, mv={1, 1, 16})
public abstract interface EngineContext
{
  @NotNull
  public abstract Context getContext();
  
  @NotNull
  public abstract GameDataFileSystem getDataFileSystem();
  
  @NotNull
  public abstract DebugConfig getDebugConfig();
  
  @NotNull
  public abstract Downloader getDownloader();
  
  public abstract boolean getEnableCodeCache();
  
  public abstract boolean getEnableOpenGlEs3();
  
  @NotNull
  public abstract EngineData getEngineData();
  
  @NotNull
  public abstract EnginePackage getEnginePackage();
  
  @Nullable
  public abstract EngineState getEngineState();
  
  @NotNull
  public abstract FontBitmapManager getFontBitmapManager();
  
  @NotNull
  public abstract GamePackage getGamePackage();
  
  @NotNull
  public abstract Executor getGameThreadExecutor();
  
  @NotNull
  public abstract GameView getGameView();
  
  public abstract int getId();
  
  @NotNull
  public abstract LifeCycleOwner getLifeCycleOwner();
  
  @NotNull
  public abstract ReentrantLock getLock();
  
  @NotNull
  public abstract Executor getMainThreadExecutor();
  
  @NotNull
  public abstract ValueHolder<ScreenShotCallback> getScreenShotCallbackHolder();
  
  @NotNull
  public abstract ScriptSystem getScriptSystem();
  
  @NotNull
  public abstract StatisticsManagerImpl getStatisticsManager();
  
  @NotNull
  public abstract TTEngine getTtEngine();
  
  @NotNull
  public abstract Executor getWorkerExecutor();
  
  public abstract boolean isAlive();
  
  public abstract void setEngineState(@Nullable EngineState paramEngineState);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EngineContext
 * JD-Core Version:    0.7.0.1
 */