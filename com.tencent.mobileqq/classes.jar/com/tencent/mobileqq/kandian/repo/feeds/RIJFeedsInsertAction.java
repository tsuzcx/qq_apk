package com.tencent.mobileqq.kandian.repo.feeds;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "", "actionType", "Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "progress", "", "priority", "watch_time", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;III)V", "getActionType", "()Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "setActionType", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;)V", "getPriority", "()I", "setPriority", "(I)V", "getProgress", "setProgress", "getWatch_time", "setWatch_time", "compareTo", "other", "toString", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertAction
  implements Comparable<RIJFeedsInsertAction>
{
  @NotNull
  private ActionType a;
  private int b;
  private int c;
  private int d;
  
  public RIJFeedsInsertAction(@NotNull ActionType paramActionType, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramActionType;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public int a(@NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "other");
    if (this.a == paramRIJFeedsInsertAction.a) {
      return 0;
    }
    if (this.c < paramRIJFeedsInsertAction.c) {
      return -1;
    }
    return 1;
  }
  
  @NotNull
  public final ActionType a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJFeedsInsertAction(actionType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", watchTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction
 * JD-Core Version:    0.7.0.1
 */