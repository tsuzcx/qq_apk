package com.tencent.mobileqq.cmshow.engine.script.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/BackgroundPlayActionTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/BackgroundInitTask;", "()V", "actionId", "", "getActionId$cmshow_impl_release", "()I", "setActionId$cmshow_impl_release", "(I)V", "actionName", "", "getActionName", "()Ljava/lang/String;", "actionPath", "getActionPath$cmshow_impl_release", "taskId", "getTaskId$cmshow_impl_release", "setTaskId$cmshow_impl_release", "setActionId", "setTaskId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract class BackgroundPlayActionTask
  extends BackgroundInitTask
{
  private int a;
  private int b;
  
  @NotNull
  public final BackgroundPlayActionTask a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  @NotNull
  public abstract String b();
  
  public final int e()
  {
    return this.a;
  }
  
  public final int f()
  {
    return this.b;
  }
  
  @NotNull
  public final String f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("background_");
    ((StringBuilder)localObject).append(this.a);
    if (StringsKt.contains$default((CharSequence)b(), (CharSequence)"_peer", false, 2, null)) {
      ((StringBuilder)localObject).append("_peer");
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.BackgroundPlayActionTask
 * JD-Core Version:    0.7.0.1
 */