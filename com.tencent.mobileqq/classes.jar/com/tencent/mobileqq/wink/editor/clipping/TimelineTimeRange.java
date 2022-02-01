package com.tencent.mobileqq.wink.editor.clipping;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/TimelineTimeRange;", "", "startTime", "", "duration", "(JJ)V", "getDuration", "()J", "getStartTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimelineTimeRange
{
  private final long a;
  private final long b;
  
  public TimelineTimeRange(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public final long a()
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
      if ((paramObject instanceof TimelineTimeRange))
      {
        paramObject = (TimelineTimeRange)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b)) {}
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
    return .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.a) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimelineTimeRange(startTime=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.TimelineTimeRange
 * JD-Core Version:    0.7.0.1
 */