package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;", "", "uuid", "", "type", "", "path", "timeData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;", "startOverlapTimeUs", "", "endOverlapTimeUs", "drawData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;JJLcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;)V", "getDrawData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "setDrawData", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;)V", "getEndOverlapTimeUs", "()J", "setEndOverlapTimeUs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getStartOverlapTimeUs", "setStartOverlapTimeUs", "getTimeData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;", "setTimeData", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;)V", "getType", "()I", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VariableClipModel
{
  @NotNull
  private final String a;
  private final int b;
  @NotNull
  private String c;
  @NotNull
  private TimeData d;
  private long e;
  private long f;
  @NotNull
  private DrawData g;
  
  public VariableClipModel(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull TimeData paramTimeData, long paramLong1, long paramLong2, @NotNull DrawData paramDrawData)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramTimeData;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramDrawData;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final TimeData d()
  {
    return this.d;
  }
  
  public final long e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VariableClipModel))
      {
        paramObject = (VariableClipModel)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e) && (this.f == paramObject.f) && (Intrinsics.areEqual(this.g, paramObject.g))) {}
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
    return this.f;
  }
  
  @NotNull
  public final DrawData g()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int n = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
    localObject = this.c;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.e);
    int i2 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.f);
    localObject = this.g;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return (((((i * 31 + n) * 31 + j) * 31 + k) * 31 + i1) * 31 + i2) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VariableClipModel(uuid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", path=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", timeData=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", startOverlapTimeUs=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", endOverlapTimeUs=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", drawData=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VariableClipModel
 * JD-Core Version:    0.7.0.1
 */