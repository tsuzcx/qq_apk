package com.tencent.mobileqq.cmshow.engine.script.plugin;

import com.tencent.mobileqq.cmshow.engine.model.Argument;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/ILifeCycle;", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "supportVariableCmd", "", "getSupportVariableCmd", "()Z", "handleEvent", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "match", "cmd", "observedEvents", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IEventPlugin
  extends ILifeCycle
{
  @NotNull
  public abstract PluginCmdConstant.PlugPriority a();
  
  @Nullable
  public abstract String a(@NotNull Argument paramArgument);
  
  public abstract boolean a(@NotNull String paramString);
  
  @NotNull
  public abstract List<String> c();
  
  public abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin
 * JD-Core Version:    0.7.0.1
 */