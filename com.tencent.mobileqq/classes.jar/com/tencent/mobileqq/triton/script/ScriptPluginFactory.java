package com.tencent.mobileqq.triton.script;

import androidx.annotation.AnyThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "", "create", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ScriptPluginFactory
{
  @AnyThread
  @NotNull
  public abstract ScriptPlugin create();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptPluginFactory
 * JD-Core Version:    0.7.0.1
 */