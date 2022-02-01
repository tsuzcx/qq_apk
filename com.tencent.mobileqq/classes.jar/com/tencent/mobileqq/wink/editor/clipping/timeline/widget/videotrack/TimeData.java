package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;", "", "timelineStartTimeUs", "", "timelineDurationUs", "scaleDurationUs", "selectDurationUs", "selectStartTimeUs", "sourceDurationUs", "sourceStartTimeUs", "(JJJJJJJ)V", "getScaleDurationUs", "()J", "getSelectDurationUs", "getSelectStartTimeUs", "getSourceDurationUs", "getSourceStartTimeUs", "getTimelineDurationUs", "getTimelineStartTimeUs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getRate", "", "getTimelineEndTime", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimeData
{
  private final long a;
  private final long b;
  private final long c;
  private final long d;
  private final long e;
  private final long f;
  private final long g;
  
  public TimeData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = paramLong6;
    this.g = paramLong7;
  }
  
  public final float a()
  {
    long l = this.d;
    if (l == 0L) {
      return 1.0F;
    }
    return (float)this.c / (float)l;
  }
  
  public final long b()
  {
    return this.a + this.b;
  }
  
  public final long c()
  {
    return this.a;
  }
  
  public final long d()
  {
    return this.b;
  }
  
  public final long e()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TimeData))
      {
        paramObject = (TimeData)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long f()
  {
    return this.d;
  }
  
  public final long g()
  {
    return this.e;
  }
  
  public final long h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return (((((.r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.a) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.c)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.d)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.e)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.f)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.g);
  }
  
  public final long i()
  {
    return this.g;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimeData(timelineStartTimeUs=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timelineDurationUs=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scaleDurationUs=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", selectDurationUs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", selectStartTimeUs=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", sourceDurationUs=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", sourceStartTimeUs=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData
 * JD-Core Version:    0.7.0.1
 */