package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "startPosition", "", "endPosition", "minDistance", "", "trackIndex", "id", "", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "(Ljava/lang/Class;IIJILjava/lang/String;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;)V", "getClazz", "()Ljava/lang/Class;", "getEndPosition", "()I", "getId", "()Ljava/lang/String;", "getMinDistance", "()J", "getScaleCalculator", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "getStartPosition", "getTrackIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toAttractPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "time", "isStart", "toDragModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "toString", "translatePxToTime", "position", "updateByDragModel", "dragModel", "updateByDragModel$qq_wink_impl_release", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragViewModel
{
  @NotNull
  private final Class<? extends IDragView> a;
  private final int b;
  private final int c;
  private final long d;
  private final int e;
  @NotNull
  private final String f;
  @Nullable
  private final ScaleCalculator g;
  
  public DragViewModel(@NotNull Class<? extends IDragView> paramClass, int paramInt1, int paramInt2, long paramLong, int paramInt3, @NotNull String paramString, @Nullable ScaleCalculator paramScaleCalculator)
  {
    this.a = paramClass;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramInt3;
    this.f = paramString;
    this.g = paramScaleCalculator;
  }
  
  private final long a(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    Pair localPair;
    if (paramBoolean)
    {
      localPair = DragModelKt.a();
      if (localPair == null) {
        break label51;
      }
      localObject = localPair.getFirst();
    }
    else
    {
      localPair = DragModelKt.a();
      if (localPair == null) {
        break label51;
      }
      localObject = localPair.getSecond();
    }
    localObject = (AttractPoint)localObject;
    label51:
    long l = 0L;
    if ((localObject != null) && (paramInt == ((AttractPoint)localObject).b()) && (((AttractPoint)localObject).a() > 0L)) {
      return ((AttractPoint)localObject).a();
    }
    localObject = this.g;
    if (localObject != null) {
      l = ((ScaleCalculator)localObject).a(paramInt);
    }
    return l;
  }
  
  @NotNull
  public final AttractPoint a(long paramLong, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.b;
    } else {
      i = this.c;
    }
    return new AttractPoint(paramLong, i, this.f, paramBoolean);
  }
  
  @NotNull
  public final DragModel a()
  {
    Object localObject = this.a;
    String str = this.f;
    localObject = new DragModel((Class)localObject, a(this.b, true), a(this.c, false), this.d, this.e, str);
    DragModelKt.a((Pair)null);
    return localObject;
  }
  
  @NotNull
  public final DragViewModel a(@NotNull DragModel paramDragModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragModel, "dragModel");
    Class localClass = paramDragModel.a();
    String str = paramDragModel.f();
    ScaleCalculator localScaleCalculator = this.g;
    int i;
    if (localScaleCalculator != null) {
      i = localScaleCalculator.b(paramDragModel.b());
    } else {
      i = 0;
    }
    localScaleCalculator = this.g;
    int j;
    if (localScaleCalculator != null) {
      j = localScaleCalculator.b(paramDragModel.c());
    } else {
      j = 0;
    }
    return a(this, localClass, i, j, paramDragModel.d(), paramDragModel.e(), str, null, 64, null);
  }
  
  @NotNull
  public final DragViewModel a(@NotNull Class<? extends IDragView> paramClass, int paramInt1, int paramInt2, long paramLong, int paramInt3, @NotNull String paramString, @Nullable ScaleCalculator paramScaleCalculator)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    return new DragViewModel(paramClass, paramInt1, paramInt2, paramLong, paramInt3, paramString, paramScaleCalculator);
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  @NotNull
  public final String e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DragViewModel))
      {
        paramObject = (DragViewModel)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g))) {}
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
    int n = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.c);
    int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.d);
    int i2 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.e);
    localObject = this.f;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.g;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (((((i * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DragViewModel(clazz=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", startPosition=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", endPosition=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", minDistance=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", trackIndex=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", scaleCalculator=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragViewModel
 * JD-Core Version:    0.7.0.1
 */