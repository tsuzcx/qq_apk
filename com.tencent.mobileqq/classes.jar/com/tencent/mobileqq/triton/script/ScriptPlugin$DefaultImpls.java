package com.tencent.mobileqq.triton.script;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle.DefaultImpls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ScriptPlugin$DefaultImpls
{
  public static void onCreate(ScriptPlugin paramScriptPlugin, @NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
  }
  
  public static void onDestroy(ScriptPlugin paramScriptPlugin)
  {
    LifeCycle.DefaultImpls.onDestroy((LifeCycle)paramScriptPlugin);
  }
  
  public static void onFirstFrame(ScriptPlugin paramScriptPlugin)
  {
    LifeCycle.DefaultImpls.onFirstFrame((LifeCycle)paramScriptPlugin);
  }
  
  public static void onGameLaunched(ScriptPlugin paramScriptPlugin, @NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    LifeCycle.DefaultImpls.onGameLaunched((LifeCycle)paramScriptPlugin, paramTritonEngine);
  }
  
  public static void onStart(ScriptPlugin paramScriptPlugin)
  {
    LifeCycle.DefaultImpls.onStart((LifeCycle)paramScriptPlugin);
  }
  
  public static void onStop(ScriptPlugin paramScriptPlugin)
  {
    LifeCycle.DefaultImpls.onStop((LifeCycle)paramScriptPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptPlugin.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */