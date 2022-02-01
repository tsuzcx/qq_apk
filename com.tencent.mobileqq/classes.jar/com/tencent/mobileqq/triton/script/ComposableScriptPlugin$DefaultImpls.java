package com.tencent.mobileqq.triton.script;

import com.tencent.mobileqq.triton.TritonEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class ComposableScriptPlugin$DefaultImpls
{
  public static void onCreate(ComposableScriptPlugin paramComposableScriptPlugin, @NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin.DefaultImpls.onCreate((ScriptPlugin)paramComposableScriptPlugin, paramTritonEngine);
  }
  
  public static void onDestroy(ComposableScriptPlugin paramComposableScriptPlugin)
  {
    ScriptPlugin.DefaultImpls.onDestroy((ScriptPlugin)paramComposableScriptPlugin);
  }
  
  public static void onFirstFrame(ComposableScriptPlugin paramComposableScriptPlugin)
  {
    ScriptPlugin.DefaultImpls.onFirstFrame((ScriptPlugin)paramComposableScriptPlugin);
  }
  
  public static void onGameLaunched(ComposableScriptPlugin paramComposableScriptPlugin, @NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin.DefaultImpls.onGameLaunched((ScriptPlugin)paramComposableScriptPlugin, paramTritonEngine);
  }
  
  public static void onStart(ComposableScriptPlugin paramComposableScriptPlugin)
  {
    ScriptPlugin.DefaultImpls.onStart((ScriptPlugin)paramComposableScriptPlugin);
  }
  
  public static void onStop(ComposableScriptPlugin paramComposableScriptPlugin)
  {
    ScriptPlugin.DefaultImpls.onStop((ScriptPlugin)paramComposableScriptPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ComposableScriptPlugin.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */