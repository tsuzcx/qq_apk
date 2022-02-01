package com.tencent.mobileqq.cmshow.engine.action;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "", "()V", "isEndState", "", "toReportErrorCode", "", "toString", "", "Lcom/tencent/mobileqq/cmshow/engine/action/UNKNOWN;", "Lcom/tencent/mobileqq/cmshow/engine/action/INIT;", "Lcom/tencent/mobileqq/cmshow/engine/action/START;", "Lcom/tencent/mobileqq/cmshow/engine/action/COMPLETE;", "Lcom/tencent/mobileqq/cmshow/engine/action/INTERRUPT;", "Lcom/tencent/mobileqq/cmshow/engine/action/ExtendActionStatus;", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract class ActionStatus
{
  public int a()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    String str = getClass().getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(str, "this::class.java.simpleName");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.action.ActionStatus
 * JD-Core Version:    0.7.0.1
 */