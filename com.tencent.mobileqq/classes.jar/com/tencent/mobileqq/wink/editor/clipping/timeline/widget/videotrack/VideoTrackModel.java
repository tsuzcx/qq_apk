package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackModel;", "", "uuid", "", "type", "", "path", "leftMargin", "leftOffset", "minLeftMargin", "width", "maxWidth", "startClipWidth", "endClipWidth", "duration", "", "minWidth", "sourceData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;", "drawData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "(Ljava/lang/String;ILjava/lang/String;IIIIIIIJILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;)V", "getDrawData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "getDuration", "()J", "setDuration", "(J)V", "getEndClipWidth", "()I", "setEndClipWidth", "(I)V", "getLeftMargin", "setLeftMargin", "getLeftOffset", "setLeftOffset", "getMaxWidth", "setMaxWidth", "getMinLeftMargin", "setMinLeftMargin", "getMinWidth", "setMinWidth", "getPath", "()Ljava/lang/String;", "getSourceData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;", "getStartClipWidth", "setStartClipWidth", "getType", "getUuid", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getEndPosition", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackModel
{
  @NotNull
  private final String a;
  private final int b;
  @NotNull
  private final String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private long k;
  private int l;
  @NotNull
  private final VariableClipModel m;
  @NotNull
  private final DrawData n;
  
  public VideoTrackModel(@NotNull String paramString1, int paramInt1, @NotNull String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong, int paramInt9, @NotNull VariableClipModel paramVariableClipModel, @NotNull DrawData paramDrawData)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramString2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = paramInt6;
    this.i = paramInt7;
    this.j = paramInt8;
    this.k = paramLong;
    this.l = paramInt9;
    this.m = paramVariableClipModel;
    this.n = paramDrawData;
  }
  
  public final int a()
  {
    return this.d + this.g;
  }
  
  @NotNull
  public final VideoTrackModel a(@NotNull String paramString1, int paramInt1, @NotNull String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong, int paramInt9, @NotNull VariableClipModel paramVariableClipModel, @NotNull DrawData paramDrawData)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uuid");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    Intrinsics.checkParameterIsNotNull(paramVariableClipModel, "sourceData");
    Intrinsics.checkParameterIsNotNull(paramDrawData, "drawData");
    return new VideoTrackModel(paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramLong, paramInt9, paramVariableClipModel, paramDrawData);
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.k = paramLong;
  }
  
  @NotNull
  public final String b()
  {
    return this.a;
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  @NotNull
  public final String d()
  {
    return this.c;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoTrackModel))
      {
        paramObject = (VideoTrackModel)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l) && (Intrinsics.areEqual(this.m, paramObject.m)) && (Intrinsics.areEqual(this.n, paramObject.n))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.e;
  }
  
  public final int g()
  {
    return this.f;
  }
  
  public final int h()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int i4 = 0;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    int i5 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
    localObject = this.c;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    int i6 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.d);
    int i7 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.e);
    int i8 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.f);
    int i9 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.g);
    int i10 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.h);
    int i11 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.i);
    int i12 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.j);
    int i13 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.k);
    int i14 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.l);
    localObject = this.m;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.n;
    if (localObject != null) {
      i4 = localObject.hashCode();
    }
    return ((((((((((((i1 * 31 + i5) * 31 + i2) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i3) * 31 + i4;
  }
  
  public final int i()
  {
    return this.h;
  }
  
  public final int j()
  {
    return this.i;
  }
  
  public final int k()
  {
    return this.j;
  }
  
  public final long l()
  {
    return this.k;
  }
  
  public final int m()
  {
    return this.l;
  }
  
  @NotNull
  public final VariableClipModel n()
  {
    return this.m;
  }
  
  @NotNull
  public final DrawData o()
  {
    return this.n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoTrackModel(uuid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", path=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", leftMargin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", leftOffset=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", minLeftMargin=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", maxWidth=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", startClipWidth=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", endClipWidth=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", minWidth=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", sourceData=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", drawData=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackModel
 * JD-Core Version:    0.7.0.1
 */