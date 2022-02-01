package com.tencent.mobileqq.triton.internal.script;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Content;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/CodeCacheSaver;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;)V", "gameLaunched", "", "lastOnResumeTime", "", "mHandler", "Landroid/os/Handler;", "mTaskRunnable", "Ljava/lang/Runnable;", "cancelAutoSaving", "", "onDestroy", "onGameLaunched", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onStart", "onStop", "saveCodeCacheIfNeeded", "scheduleAutoSaving", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class CodeCacheSaver
  implements LifeCycle
{
  public static final CodeCacheSaver.Companion Companion = new CodeCacheSaver.Companion(null);
  private static final long DELAY_SAVING_CACHE_AFTER_PRELOAD = 10000L;
  private static final long RUN_DURATION_TO_SAVE_CODE_CACHE_MS = 60000L;
  private final EnginePackage enginePackage;
  private boolean gameLaunched;
  private long lastOnResumeTime;
  private final Handler mHandler;
  private final Runnable mTaskRunnable;
  private final ScriptSystem scriptSystem;
  
  public CodeCacheSaver(@NotNull ScriptSystem paramScriptSystem, @NotNull EnginePackage paramEnginePackage)
  {
    this.scriptSystem = paramScriptSystem;
    this.enginePackage = paramEnginePackage;
    this.lastOnResumeTime = 9223372036854775807L;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mTaskRunnable = ((Runnable)new CodeCacheSaver.mTaskRunnable.1(this));
  }
  
  private final void saveCodeCacheIfNeeded()
  {
    Object localObject = (ScriptFile)MapsKt.getValue(ScriptLoader.INSTANCE.getEngineScripts(this.enginePackage), ScriptContextType.MAIN);
    if ((localObject instanceof ScriptFile.Path)) {
      localObject = ((ScriptFile.Path)localObject).getCodeCache();
    } else if ((localObject instanceof ScriptFile.Content)) {
      localObject = ((ScriptFile.Content)localObject).getCodeCache();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((File)localObject).exists())) {
      this.scriptSystem.saveCodeCache();
    }
  }
  
  public final void cancelAutoSaving()
  {
    this.mHandler.removeCallbacks(this.mTaskRunnable);
  }
  
  public void onDestroy()
  {
    LifeCycle.DefaultImpls.onDestroy(this);
    cancelAutoSaving();
  }
  
  public void onFirstFrame()
  {
    LifeCycle.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    this.gameLaunched = true;
    this.lastOnResumeTime = SystemClock.uptimeMillis();
  }
  
  public void onStart()
  {
    this.lastOnResumeTime = SystemClock.uptimeMillis();
  }
  
  public void onStop()
  {
    if ((this.gameLaunched) && (SystemClock.uptimeMillis() - this.lastOnResumeTime > 60000L)) {
      this.scriptSystem.saveCodeCache();
    }
  }
  
  public final void scheduleAutoSaving()
  {
    this.mHandler.removeCallbacks(this.mTaskRunnable);
    this.mHandler.postDelayed(this.mTaskRunnable, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.CodeCacheSaver
 * JD-Core Version:    0.7.0.1
 */