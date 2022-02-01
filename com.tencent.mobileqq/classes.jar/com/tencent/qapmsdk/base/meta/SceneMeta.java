package com.tencent.qapmsdk.base.meta;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/SceneMeta;", "Lcom/tencent/qapmsdk/base/meta/MonitorMeta;", "stage", "", "cpu", "", "memory", "", "duration", "(Ljava/lang/String;DJJ)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class SceneMeta
  extends MonitorMeta
{
  @SerializedName("cpu")
  @JvmField
  public double cpu;
  @SerializedName("duration")
  @JvmField
  public long duration;
  @SerializedName("memory")
  @JvmField
  public long memory;
  @SerializedName("stage")
  @JvmField
  @NotNull
  public String stage;
  
  public SceneMeta()
  {
    this(null, 0.0D, 0L, 0L, 15, null);
  }
  
  public SceneMeta(@NotNull String paramString, double paramDouble, long paramLong1, long paramLong2)
  {
    this.stage = paramString;
    this.cpu = paramDouble;
    this.memory = paramLong1;
    this.duration = paramLong2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.stage;
  }
  
  public final double component2()
  {
    return this.cpu;
  }
  
  public final long component3()
  {
    return this.memory;
  }
  
  public final long component4()
  {
    return this.duration;
  }
  
  @NotNull
  public final SceneMeta copy(@NotNull String paramString, double paramDouble, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "stage");
    return new SceneMeta(paramString, paramDouble, paramLong1, paramLong2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof SceneMeta))
      {
        paramObject = (SceneMeta)paramObject;
        if ((Intrinsics.areEqual(this.stage, paramObject.stage)) && (Double.compare(this.cpu, paramObject.cpu) == 0))
        {
          int i;
          if (this.memory == paramObject.memory) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.duration == paramObject.duration) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0) {
              return true;
            }
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    String str = this.stage;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    long l = Double.doubleToLongBits(this.cpu);
    int j = (int)(l ^ l >>> 32);
    l = this.memory;
    int k = (int)(l ^ l >>> 32);
    l = this.duration;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SceneMeta(stage=");
    localStringBuilder.append(this.stage);
    localStringBuilder.append(", cpu=");
    localStringBuilder.append(this.cpu);
    localStringBuilder.append(", memory=");
    localStringBuilder.append(this.memory);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.SceneMeta
 * JD-Core Version:    0.7.0.1
 */