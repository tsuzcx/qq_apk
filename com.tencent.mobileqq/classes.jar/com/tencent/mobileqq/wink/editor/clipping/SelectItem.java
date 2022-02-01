package com.tencent.mobileqq.wink.editor.clipping;

import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/SelectItem;", "T", "", "id", "", "type", "", "timeRange", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineTimeRange;", "extra", "(Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/clipping/TimelineTimeRange;Ljava/lang/Object;)V", "getExtra", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "getTimeRange", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineTimeRange;", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/clipping/TimelineTimeRange;Ljava/lang/Object;)Lcom/tencent/mobileqq/wink/editor/clipping/SelectItem;", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SelectItem<T>
{
  @NotNull
  private final String a;
  private final int b;
  @NotNull
  private final TimelineTimeRange c;
  private final T d;
  
  public SelectItem(@NotNull String paramString, int paramInt, @NotNull TimelineTimeRange paramTimelineTimeRange, T paramT)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramTimelineTimeRange;
    this.d = paramT;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SelectItem))
      {
        paramObject = (SelectItem)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int m = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
    localObject = this.c;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((i * 31 + m) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelectItem(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", timeRange=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", extra=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.SelectItem
 * JD-Core Version:    0.7.0.1
 */