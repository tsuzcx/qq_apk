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
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof SceneMeta)) {
        break label101;
      }
      paramObject = (SceneMeta)paramObject;
      bool1 = bool2;
      if (!Intrinsics.areEqual(this.stage, paramObject.stage)) {
        break label101;
      }
      bool1 = bool2;
      if (Double.compare(this.cpu, paramObject.cpu) != 0) {
        break label101;
      }
      if (this.memory != paramObject.memory) {
        break label103;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label101;
      }
      if (this.duration != paramObject.duration) {
        break label108;
      }
    }
    label101:
    label103:
    label108:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
    }
  }
  
  public int hashCode()
  {
    String str = this.stage;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = Double.doubleToLongBits(this.cpu);
      int j = (int)(l ^ l >>> 32);
      l = this.memory;
      int k = (int)(l ^ l >>> 32);
      l = this.duration;
      return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
    }
  }
  
  @NotNull
  public String toString()
  {
    return "SceneMeta(stage=" + this.stage + ", cpu=" + this.cpu + ", memory=" + this.memory + ", duration=" + this.duration + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.SceneMeta
 * JD-Core Version:    0.7.0.1
 */