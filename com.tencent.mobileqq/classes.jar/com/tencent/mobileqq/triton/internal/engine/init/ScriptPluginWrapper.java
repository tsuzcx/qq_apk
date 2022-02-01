package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.script.plugin.FontPlugin;
import com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginComposer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptPluginWrapper;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "()V", "<set-?>", "externalPlugin", "getExternalPlugin", "()Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "realPlugin", "init", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "onCall", "", "eventName", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "onDestroy", "onFirstFrame", "onGameLaunched", "onStart", "onStop", "Triton_release"}, k=1, mv={1, 1, 16})
final class ScriptPluginWrapper
  implements ScriptPlugin
{
  @NotNull
  private ScriptPlugin externalPlugin;
  private ScriptPlugin realPlugin;
  
  @NotNull
  public final ScriptPlugin getExternalPlugin()
  {
    ScriptPlugin localScriptPlugin = this.externalPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("externalPlugin");
    }
    return localScriptPlugin;
  }
  
  public final void init(@NotNull EngineContext paramEngineContext, @NotNull ScriptPlugin paramScriptPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineContext, "engineContext");
    Intrinsics.checkParameterIsNotNull(paramScriptPlugin, "externalPlugin");
    this.externalPlugin = paramScriptPlugin;
    this.realPlugin = ((ScriptPlugin)new ScriptPluginComposer(CollectionsKt.listOf(new ScriptPlugin[] { paramScriptPlugin, (ScriptPlugin)new SubpackagePlugin(paramEngineContext), (ScriptPlugin)new FontPlugin(paramEngineContext) })));
    paramEngineContext = paramEngineContext.getLifeCycleOwner();
    paramScriptPlugin = this.realPlugin;
    if (paramScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    paramEngineContext.observeLifeCycle((LifeCycle)paramScriptPlugin);
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    return localScriptPlugin.onCall(paramString, paramArgument);
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    localScriptPlugin.onCreate(paramTritonEngine);
  }
  
  public void onDestroy()
  {
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    localScriptPlugin.onDestroy();
  }
  
  public void onFirstFrame()
  {
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    localScriptPlugin.onFirstFrame();
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    localScriptPlugin.onGameLaunched(paramTritonEngine);
  }
  
  public void onStart()
  {
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    localScriptPlugin.onStart();
  }
  
  public void onStop()
  {
    ScriptPlugin localScriptPlugin = this.realPlugin;
    if (localScriptPlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
    }
    localScriptPlugin.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.ScriptPluginWrapper
 * JD-Core Version:    0.7.0.1
 */