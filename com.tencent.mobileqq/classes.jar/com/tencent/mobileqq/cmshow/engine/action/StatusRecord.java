package com.tencent.mobileqq.cmshow.engine.action;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/action/StatusRecord;", "", "status", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "timeStamp", "", "(Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;J)V", "getStatus", "()Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "getTimeStamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class StatusRecord
{
  @NotNull
  private final ActionStatus a;
  private final long b;
  
  public StatusRecord(@NotNull ActionStatus paramActionStatus, long paramLong)
  {
    this.a = paramActionStatus;
    this.b = paramLong;
  }
  
  @NotNull
  public final ActionStatus a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StatusRecord))
      {
        paramObject = (StatusRecord)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    ActionStatus localActionStatus = this.a;
    int i;
    if (localActionStatus != null) {
      i = localActionStatus.hashCode();
    } else {
      i = 0;
    }
    long l = this.b;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StatusRecord(status=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.action.StatusRecord
 * JD-Core Version:    0.7.0.1
 */