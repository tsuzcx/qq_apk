package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniScriptPluginFactory;", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "()V", "create", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniScriptPluginFactory
  implements ScriptPluginFactory
{
  public static final QQMiniScriptPluginFactory INSTANCE = new QQMiniScriptPluginFactory();
  
  @NotNull
  public ScriptPlugin create()
  {
    return (ScriptPlugin)new QQMiniScriptPlugin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniScriptPluginFactory
 * JD-Core Version:    0.7.0.1
 */