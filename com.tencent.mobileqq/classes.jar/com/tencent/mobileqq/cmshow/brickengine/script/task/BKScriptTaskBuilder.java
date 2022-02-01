package com.tencent.mobileqq.cmshow.brickengine.script.task;

import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/script/task/BKScriptTaskBuilder;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/IScriptTaskBuilder;", "()V", "buildTask", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "type", "Lcom/tencent/mobileqq/cmshow/engine/script/task/ScriptTaskType;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class BKScriptTaskBuilder
  implements IScriptTaskBuilder
{
  @NotNull
  public AbsScriptTask a(@NotNull ScriptTaskType paramScriptTaskType)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptTaskType, "type");
    int i = BKScriptTaskBuilder.WhenMappings.a[paramScriptTaskType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              return (AbsScriptTask)new BKBackgroundPlayActionTask();
            }
            throw new NoWhenBranchMatchedException();
          }
          return (AbsScriptTask)new BKBackgroundInitTask();
        }
        return (AbsScriptTask)new BKPlayActionTask();
      }
      return (AbsScriptTask)new BKInitSpriteTask();
    }
    return (AbsScriptTask)new BKCommonInitTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.script.task.BKScriptTaskBuilder
 * JD-Core Version:    0.7.0.1
 */