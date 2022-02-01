package com.tencent.tkd.topicsdk.framework.events;

import com.tencent.tkd.topicsdk.bean.PublishRestrictInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/RestrictInfoEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishRestrictInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishRestrictInfo;)V", "getInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishRestrictInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RestrictInfoEvent
  implements IEvent
{
  @NotNull
  private final PublishRestrictInfo a;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RestrictInfoEvent))
      {
        paramObject = (RestrictInfoEvent)paramObject;
        if (Intrinsics.areEqual(this.a, paramObject.a)) {}
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
    PublishRestrictInfo localPublishRestrictInfo = this.a;
    if (localPublishRestrictInfo != null) {
      return localPublishRestrictInfo.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RestrictInfoEvent(info=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.RestrictInfoEvent
 * JD-Core Version:    0.7.0.1
 */