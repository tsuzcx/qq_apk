package com.tencent.mobileqq.cmshow.brickengine.script.task;

import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/script/task/BKScriptTaskBuilder;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/IScriptTaskBuilder;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "buildTask", "T", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "type", "Lcom/tencent/mobileqq/cmshow/engine/script/task/ScriptTaskType;", "(Lcom/tencent/mobileqq/cmshow/engine/script/task/ScriptTaskType;)Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class BKScriptTaskBuilder
  implements IScriptTaskBuilder
{
  private final EngineContext a;
  
  public BKScriptTaskBuilder(@NotNull EngineContext paramEngineContext)
  {
    this.a = paramEngineContext;
  }
  
  @NotNull
  public <T extends AbsScriptTask> T a(@NotNull ScriptTaskType paramScriptTaskType)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptTaskType, "type");
    IApolloResManager localIApolloResManager = this.a.h().a();
    int i = BKScriptTaskBuilder.WhenMappings.$EnumSwitchMapping$0[paramScriptTaskType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              return (AbsScriptTask)new BKBackgroundPlayActionTask(localIApolloResManager);
            }
            throw new NoWhenBranchMatchedException();
          }
          return (AbsScriptTask)new BKBackgroundInitTask(localIApolloResManager);
        }
        return (AbsScriptTask)new BKPlayActionTask(this.a);
      }
      return (AbsScriptTask)new BKInitSpriteTask(localIApolloResManager);
    }
    return (AbsScriptTask)new BKCommonInitTask(localIApolloResManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.script.task.BKScriptTaskBuilder
 * JD-Core Version:    0.7.0.1
 */