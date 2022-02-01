package com.tencent.mobileqq.cmshow.engine.script;

import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "", "scriptBuilder", "Lcom/tencent/mobileqq/cmshow/engine/script/task/IScriptTaskBuilder;", "getScriptBuilder", "()Lcom/tencent/mobileqq/cmshow/engine/script/task/IScriptTaskBuilder;", "evaluateScript", "", "script", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "onNativeEvent", "cmd", "", "respData", "onScriptEvent", "reqParams", "registerPlugin", "plugin", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "unRegisterPlugin", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IScriptService
{
  public abstract void a(@NotNull Script paramScript);
  
  public abstract void a(@NotNull IEventPlugin paramIEventPlugin);
  
  public abstract void a(@NotNull String paramString1, @Nullable String paramString2);
  
  @NotNull
  public abstract IScriptTaskBuilder b();
  
  public abstract void b(@NotNull IEventPlugin paramIEventPlugin);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.IScriptService
 * JD-Core Version:    0.7.0.1
 */