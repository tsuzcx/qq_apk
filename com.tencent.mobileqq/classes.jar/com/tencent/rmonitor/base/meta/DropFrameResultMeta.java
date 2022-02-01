package com.tencent.rmonitor.base.meta;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "scene", "", "dropCount", "", "duration", "", "dropIntervals", "", "totalDuration", "", "refreshDuration", "refreshCount", "hitchesDuration", "state", "(Ljava/lang/String;IF[JJ[J[JJI)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyFrom", "", "other", "equals", "", "", "hashCode", "reset", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DropFrameResultMeta
  extends MonitorMeta
{
  @JvmField
  public int dropCount;
  @JvmField
  @NotNull
  public long[] dropIntervals;
  @JvmField
  public float duration;
  @JvmField
  public long hitchesDuration;
  @JvmField
  @NotNull
  public long[] refreshCount;
  @JvmField
  @NotNull
  public long[] refreshDuration;
  @JvmField
  @NotNull
  public String scene;
  @JvmField
  public int state;
  @JvmField
  public long totalDuration;
  
  public DropFrameResultMeta()
  {
    this(null, 0, 0.0F, null, 0L, null, null, 0L, 0, 511, null);
  }
  
  public DropFrameResultMeta(@NotNull String paramString, int paramInt1, float paramFloat, @NotNull long[] paramArrayOfLong1, long paramLong1, @NotNull long[] paramArrayOfLong2, @NotNull long[] paramArrayOfLong3, long paramLong2, int paramInt2)
  {
    this.scene = paramString;
    this.dropCount = paramInt1;
    this.duration = paramFloat;
    this.dropIntervals = paramArrayOfLong1;
    this.totalDuration = paramLong1;
    this.refreshDuration = paramArrayOfLong2;
    this.refreshCount = paramArrayOfLong3;
    this.hitchesDuration = paramLong2;
    this.state = paramInt2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.scene;
  }
  
  public final int component2()
  {
    return this.dropCount;
  }
  
  public final float component3()
  {
    return this.duration;
  }
  
  @NotNull
  public final long[] component4()
  {
    return this.dropIntervals;
  }
  
  public final long component5()
  {
    return this.totalDuration;
  }
  
  @NotNull
  public final long[] component6()
  {
    return this.refreshDuration;
  }
  
  @NotNull
  public final long[] component7()
  {
    return this.refreshCount;
  }
  
  public final long component8()
  {
    return this.hitchesDuration;
  }
  
  public final int component9()
  {
    return this.state;
  }
  
  @NotNull
  public final DropFrameResultMeta copy(@NotNull String paramString, int paramInt1, float paramFloat, @NotNull long[] paramArrayOfLong1, long paramLong1, @NotNull long[] paramArrayOfLong2, @NotNull long[] paramArrayOfLong3, long paramLong2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "dropIntervals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "refreshDuration");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong3, "refreshCount");
    return new DropFrameResultMeta(paramString, paramInt1, paramFloat, paramArrayOfLong1, paramLong1, paramArrayOfLong2, paramArrayOfLong3, paramLong2, paramInt2);
  }
  
  public final void copyFrom(@NotNull DropFrameResultMeta paramDropFrameResultMeta)
  {
    Intrinsics.checkParameterIsNotNull(paramDropFrameResultMeta, "other");
    this.scene = paramDropFrameResultMeta.scene;
    this.state = paramDropFrameResultMeta.state;
    this.dropCount = paramDropFrameResultMeta.dropCount;
    this.duration = paramDropFrameResultMeta.duration;
    int k = this.dropIntervals.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      this.dropIntervals[i] = paramDropFrameResultMeta.dropIntervals[i];
      i += 1;
    }
    this.totalDuration = paramDropFrameResultMeta.totalDuration;
    this.hitchesDuration = paramDropFrameResultMeta.hitchesDuration;
    k = this.refreshCount.length;
    i = 0;
    while (i < k)
    {
      this.refreshCount[i] = paramDropFrameResultMeta.refreshCount[i];
      i += 1;
    }
    k = this.refreshDuration.length;
    i = j;
    while (i < k)
    {
      this.refreshDuration[i] = paramDropFrameResultMeta.refreshDuration[i];
      i += 1;
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((DropFrameResultMeta)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (DropFrameResultMeta)paramObject;
      if ((Intrinsics.areEqual(this.scene, paramObject.scene) ^ true)) {
        return false;
      }
      if (this.dropCount != paramObject.dropCount) {
        return false;
      }
      if (Math.abs(this.duration - paramObject.duration) > 0.001F) {
        return false;
      }
      if (!Arrays.equals(this.dropIntervals, paramObject.dropIntervals)) {
        return false;
      }
      if (this.totalDuration != paramObject.totalDuration) {
        return false;
      }
      if (!Arrays.equals(this.refreshDuration, paramObject.refreshDuration)) {
        return false;
      }
      if (!Arrays.equals(this.refreshCount, paramObject.refreshCount)) {
        return false;
      }
      if (this.hitchesDuration != paramObject.hitchesDuration) {
        return false;
      }
      return this.state == paramObject.state;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.rmonitor.base.meta.DropFrameResultMeta");
  }
  
  public int hashCode()
  {
    return (((((((this.scene.hashCode() * 31 + this.dropCount) * 31 + Float.valueOf(this.duration).hashCode()) * 31 + Arrays.hashCode(this.dropIntervals)) * 31 + Long.valueOf(this.totalDuration).hashCode()) * 31 + Arrays.hashCode(this.refreshDuration)) * 31 + Arrays.hashCode(this.refreshCount)) * 31 + Long.valueOf(this.hitchesDuration).hashCode()) * 31 + this.state;
  }
  
  public void reset()
  {
    this.scene = "";
    int j = 0;
    this.state = 0;
    this.dropCount = 0;
    this.duration = 0.0F;
    int k = this.dropIntervals.length;
    int i = 0;
    while (i < k)
    {
      this.dropIntervals[i] = 0L;
      i += 1;
    }
    this.totalDuration = 0L;
    this.hitchesDuration = 0L;
    k = this.refreshCount.length;
    i = 0;
    while (i < k)
    {
      this.refreshCount[i] = 0L;
      i += 1;
    }
    k = this.refreshDuration.length;
    i = j;
    while (i < k)
    {
      this.refreshDuration[i] = 0L;
      i += 1;
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DropFrameResultMeta(scene=");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(", dropCount=");
    localStringBuilder.append(this.dropCount);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", dropIntervals=");
    localStringBuilder.append(Arrays.toString(this.dropIntervals));
    localStringBuilder.append(", totalDuration=");
    localStringBuilder.append(this.totalDuration);
    localStringBuilder.append(", refreshDuration=");
    localStringBuilder.append(Arrays.toString(this.refreshDuration));
    localStringBuilder.append(", refreshCount=");
    localStringBuilder.append(Arrays.toString(this.refreshCount));
    localStringBuilder.append(", hitchesDuration=");
    localStringBuilder.append(this.hitchesDuration);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.DropFrameResultMeta
 * JD-Core Version:    0.7.0.1
 */