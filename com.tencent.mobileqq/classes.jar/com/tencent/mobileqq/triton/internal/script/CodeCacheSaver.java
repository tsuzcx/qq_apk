package com.tencent.mobileqq.triton.internal.script;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/CodeCacheSaver;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;)V", "gameLaunched", "", "lastOnResumeTime", "", "onGameLaunched", "", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onStart", "onStop", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class CodeCacheSaver
  implements LifeCycle
{
  public static final CodeCacheSaver.Companion Companion = new CodeCacheSaver.Companion(null);
  private static final long RUN_DURATION_TO_SAVE_CODE_CACHE_MS = 60000L;
  private boolean gameLaunched;
  private long lastOnResumeTime;
  private final ScriptSystem scriptSystem;
  
  public CodeCacheSaver(@NotNull ScriptSystem paramScriptSystem)
  {
    this.scriptSystem = paramScriptSystem;
    this.lastOnResumeTime = 9223372036854775807L;
  }
  
  public void onDestroy()
  {
    LifeCycle.DefaultImpls.onDestroy(this);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.CodeCacheSaver
 * JD-Core Version:    0.7.0.1
 */