package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.qqmini.minigame.GameJsPluginEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniScriptPluginFactory;", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "()V", "create", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniScriptPluginFactory
  implements ScriptPluginFactory
{
  public static final MiniScriptPluginFactory INSTANCE = new MiniScriptPluginFactory();
  
  @NotNull
  public ScriptPlugin create()
  {
    return (ScriptPlugin)new GameJsPluginEngine();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniScriptPluginFactory
 * JD-Core Version:    0.7.0.1
 */