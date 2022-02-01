package com.tencent.mobileqq.kandian.repo.feeds;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "", "actionType", "Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "progress", "", "priority", "watch_time", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;III)V", "getActionType", "()Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "setActionType", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;)V", "getPriority", "()I", "setPriority", "(I)V", "getProgress", "setProgress", "getWatch_time", "setWatch_time", "compareTo", "other", "toString", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertAction
  implements Comparable<RIJFeedsInsertAction>
{
  private int jdField_a_of_type_Int;
  @NotNull
  private ActionType jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsActionType;
  private int b;
  private int c;
  
  public RIJFeedsInsertAction(@NotNull ActionType paramActionType, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsActionType = paramActionType;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(@NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "other");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsActionType == paramRIJFeedsInsertAction.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsActionType) {
      return 0;
    }
    if (this.b < paramRIJFeedsInsertAction.b) {
      return -1;
    }
    return 1;
  }
  
  @NotNull
  public final ActionType a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsActionType;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJFeedsInsertAction(actionType=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsActionType);
    localStringBuilder.append(", progress=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", watchTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction
 * JD-Core Version:    0.7.0.1
 */