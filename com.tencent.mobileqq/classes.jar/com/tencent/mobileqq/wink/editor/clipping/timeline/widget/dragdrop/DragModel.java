package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "startTime", "", "endTime", "minDistance", "trackIndex", "", "id", "", "(Ljava/lang/Class;JJJILjava/lang/String;)V", "getClazz", "()Ljava/lang/Class;", "getEndTime", "()J", "getId", "()Ljava/lang/String;", "getMinDistance", "getStartTime", "getTrackIndex", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toDragViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "toDragViewModel$qq_wink_impl_release", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragModel
{
  @NotNull
  private final Class<? extends IDragView> a;
  private final long b;
  private final long c;
  private final long d;
  private final int e;
  @NotNull
  private final String f;
  
  public DragModel(@NotNull Class<? extends IDragView> paramClass, long paramLong1, long paramLong2, long paramLong3, int paramInt, @NotNull String paramString)
  {
    this.a = paramClass;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong3;
    this.e = paramInt;
    this.f = paramString;
  }
  
  @NotNull
  public final Class<? extends IDragView> a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final long d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DragModel))
      {
        paramObject = (DragModel)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int k = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
    int m = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.c);
    int n = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.d);
    int i1 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.e);
    localObject = this.f;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DragModel(clazz=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", minDistance=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", trackIndex=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModel
 * JD-Core Version:    0.7.0.1
 */