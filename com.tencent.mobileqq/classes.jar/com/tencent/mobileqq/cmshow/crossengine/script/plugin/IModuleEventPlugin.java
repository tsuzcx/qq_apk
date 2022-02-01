package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "handleEvent", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleModuleEvent", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "observedEvents", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IModuleEventPlugin
  extends IEventPlugin
{
  @NotNull
  public abstract String a();
  
  @Nullable
  public abstract JSONObject a(@NotNull CEArgument paramCEArgument);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.IModuleEventPlugin
 * JD-Core Version:    0.7.0.1
 */