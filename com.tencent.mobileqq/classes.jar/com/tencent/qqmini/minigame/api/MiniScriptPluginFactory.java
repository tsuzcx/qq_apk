package com.tencent.qqmini.minigame.api;

import android.content.Context;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.qqmini.minigame.GameJsPluginEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniScriptPluginFactory;", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "()V", "create", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "context", "Landroid/content/Context;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniScriptPluginFactory
  implements ScriptPluginFactory
{
  public static final MiniScriptPluginFactory INSTANCE = new MiniScriptPluginFactory();
  
  @NotNull
  public ScriptPlugin create(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (ScriptPlugin)new GameJsPluginEngine(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniScriptPluginFactory
 * JD-Core Version:    0.7.0.1
 */