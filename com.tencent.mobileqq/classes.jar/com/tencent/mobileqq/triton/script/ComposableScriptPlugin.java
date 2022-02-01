package com.tencent.mobileqq.triton.script;

import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ComposableScriptPlugin
  extends ScriptPlugin
{
  @NotNull
  public abstract Set<String> getSupportedEvents();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ComposableScriptPlugin
 * JD-Core Version:    0.7.0.1
 */