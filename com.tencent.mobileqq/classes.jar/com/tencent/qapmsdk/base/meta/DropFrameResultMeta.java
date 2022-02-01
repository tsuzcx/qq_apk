package com.tencent.qapmsdk.base.meta;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;", "Lcom/tencent/qapmsdk/base/meta/MonitorMeta;", "dropCount", "", "duration", "", "dropIntervals", "", "scene", "", "smoothTime", "(IF[JLjava/lang/String;F)V", "state", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "reset", "", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
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
  @NotNull
  public String scene;
  @JvmField
  public float smoothTime;
  @JvmField
  public int state;
  
  public DropFrameResultMeta()
  {
    this(0, 0.0F, null, null, 0.0F, 31, null);
  }
  
  public DropFrameResultMeta(int paramInt, float paramFloat1, @NotNull long[] paramArrayOfLong, @NotNull String paramString, float paramFloat2)
  {
    this.dropCount = paramInt;
    this.duration = paramFloat1;
    this.dropIntervals = paramArrayOfLong;
    this.scene = paramString;
    this.smoothTime = paramFloat2;
  }
  
  public final int component1()
  {
    return this.dropCount;
  }
  
  public final float component2()
  {
    return this.duration;
  }
  
  @NotNull
  public final long[] component3()
  {
    return this.dropIntervals;
  }
  
  @NotNull
  public final String component4()
  {
    return this.scene;
  }
  
  public final float component5()
  {
    return this.smoothTime;
  }
  
  @NotNull
  public final DropFrameResultMeta copy(int paramInt, float paramFloat1, @NotNull long[] paramArrayOfLong, @NotNull String paramString, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "dropIntervals");
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    return new DropFrameResultMeta(paramInt, paramFloat1, paramArrayOfLong, paramString, paramFloat2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DropFrameResultMeta))
      {
        paramObject = (DropFrameResultMeta)paramObject;
        int i;
        if (this.dropCount == paramObject.dropCount) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (Float.compare(this.duration, paramObject.duration) == 0) && (Intrinsics.areEqual(this.dropIntervals, paramObject.dropIntervals)) && (Intrinsics.areEqual(this.scene, paramObject.scene)) && (Float.compare(this.smoothTime, paramObject.smoothTime) == 0)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int k = this.dropCount;
    int m = Float.floatToIntBits(this.duration);
    Object localObject = this.dropIntervals;
    int j = 0;
    int i;
    if (localObject != null) {
      i = Arrays.hashCode((long[])localObject);
    } else {
      i = 0;
    }
    localObject = this.scene;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (((k * 31 + m) * 31 + i) * 31 + j) * 31 + Float.floatToIntBits(this.smoothTime);
  }
  
  public void reset()
  {
    this.dropCount = 0;
    this.duration = 0.0F;
    int j = this.dropIntervals.length;
    int i = 0;
    while (i < j)
    {
      this.dropIntervals[i] = 0L;
      i += 1;
    }
    this.scene = "";
    this.state = 0;
    this.smoothTime = 0.0F;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DropFrameResultMeta(dropCount=");
    localStringBuilder.append(this.dropCount);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", dropIntervals=");
    localStringBuilder.append(Arrays.toString(this.dropIntervals));
    localStringBuilder.append(", scene=");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(", smoothTime=");
    localStringBuilder.append(this.smoothTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.DropFrameResultMeta
 * JD-Core Version:    0.7.0.1
 */