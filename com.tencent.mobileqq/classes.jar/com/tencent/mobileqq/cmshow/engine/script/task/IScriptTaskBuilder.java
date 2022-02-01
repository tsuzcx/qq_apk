package com.tencent.mobileqq.cmshow.engine.script.task;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/IScriptTaskBuilder;", "", "buildTask", "T", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "type", "Lcom/tencent/mobileqq/cmshow/engine/script/task/ScriptTaskType;", "(Lcom/tencent/mobileqq/cmshow/engine/script/task/ScriptTaskType;)Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IScriptTaskBuilder
{
  @NotNull
  public abstract <T extends AbsScriptTask> T a(@NotNull ScriptTaskType paramScriptTaskType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder
 * JD-Core Version:    0.7.0.1
 */