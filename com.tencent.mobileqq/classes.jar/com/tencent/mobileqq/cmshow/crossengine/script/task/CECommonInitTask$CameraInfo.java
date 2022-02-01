package com.tencent.mobileqq.cmshow.crossengine.script.task;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CECommonInitTask$CameraInfo;", "", "X", "", "Y", "Z", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getX", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getY", "getZ", "component1", "component2", "component3", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CECommonInitTask$CameraInfo;", "equals", "", "other", "hashCode", "", "toString", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECommonInitTask$CameraInfo
{
  @Nullable
  private final Float a;
  @Nullable
  private final Float b;
  @Nullable
  private final Float c;
  
  public CECommonInitTask$CameraInfo()
  {
    this(null, null, null, 7, null);
  }
  
  public CECommonInitTask$CameraInfo(@Nullable Float paramFloat1, @Nullable Float paramFloat2, @Nullable Float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  @Nullable
  public final Float a()
  {
    return this.a;
  }
  
  @Nullable
  public final Float b()
  {
    return this.b;
  }
  
  @Nullable
  public final Float c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CameraInfo))
      {
        paramObject = (CameraInfo)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    Float localFloat = this.a;
    int k = 0;
    int i;
    if (localFloat != null) {
      i = localFloat.hashCode();
    } else {
      i = 0;
    }
    localFloat = this.b;
    int j;
    if (localFloat != null) {
      j = localFloat.hashCode();
    } else {
      j = 0;
    }
    localFloat = this.c;
    if (localFloat != null) {
      k = localFloat.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraInfo(X=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", Y=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", Z=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.task.CECommonInitTask.CameraInfo
 * JD-Core Version:    0.7.0.1
 */