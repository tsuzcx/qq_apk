package com.tencent.mobileqq.triton.script;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onCall", "", "eventName", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", "", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ScriptPlugin
  extends LifeCycle
{
  @Nullable
  public abstract String onCall(@NotNull String paramString, @NotNull Argument paramArgument);
  
  public abstract void onCreate(@NotNull TritonEngine paramTritonEngine);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptPlugin
 * JD-Core Version:    0.7.0.1
 */