package com.tencent.mobileqq.cmshow.crossengine.script.task;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.crossengine.resource.util.CEResUtil;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CEPlayActionTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "buildParams", "", "skipCheck", "", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEPlayActionTask
  extends PlayActionTask
{
  @Deprecated
  public static final CEPlayActionTask.Companion a = new CEPlayActionTask.Companion(null);
  
  public CEPlayActionTask(@NotNull EngineContext paramEngineContext)
  {
    super(paramEngineContext);
  }
  
  private final boolean n(int paramInt)
  {
    return (paramInt < ApolloConstant.f) || (m(l()));
  }
  
  @NotNull
  public String b()
  {
    boolean bool;
    if (n(c())) {
      bool = true;
    } else {
      bool = CEResUtil.b(c(), x());
    }
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("build playAction script without actionResDone, actionId:");
      localStringBuilder.append(c());
      QLog.e("[cmshow][ScriptTask][CEPlayActionTask]", 1, localStringBuilder.toString());
    }
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.task.CEPlayActionTask
 * JD-Core Version:    0.7.0.1
 */