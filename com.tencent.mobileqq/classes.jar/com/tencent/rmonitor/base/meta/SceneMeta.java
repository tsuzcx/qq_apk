package com.tencent.rmonitor.base.meta;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/SceneMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "stage", "", "cpu", "", "memory", "", "fps", "ioCnt", "ioSize", "netRec", "netSend", "netPack", "duration", "(Ljava/lang/String;DJJJJJJJJ)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class SceneMeta
  extends MonitorMeta
{
  @SerializedName("cpu")
  @JvmField
  public double cpu;
  @SerializedName("duration")
  @JvmField
  public long duration;
  @SerializedName("fps")
  @JvmField
  public long fps;
  @SerializedName("ioCnt")
  @JvmField
  public long ioCnt;
  @SerializedName("ioSize")
  @JvmField
  public long ioSize;
  @SerializedName("memory")
  @JvmField
  public long memory;
  @SerializedName("netPack")
  @JvmField
  public long netPack;
  @SerializedName("netRec")
  @JvmField
  public long netRec;
  @SerializedName("netSend")
  @JvmField
  public long netSend;
  @SerializedName("stage")
  @JvmField
  @NotNull
  public String stage;
  
  public SceneMeta()
  {
    this(null, 0.0D, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 1023, null);
  }
  
  public SceneMeta(@NotNull String paramString, double paramDouble, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    this.stage = paramString;
    this.cpu = paramDouble;
    this.memory = paramLong1;
    this.fps = paramLong2;
    this.ioCnt = paramLong3;
    this.ioSize = paramLong4;
    this.netRec = paramLong5;
    this.netSend = paramLong6;
    this.netPack = paramLong7;
    this.duration = paramLong8;
  }
  
  @NotNull
  public final String component1()
  {
    return this.stage;
  }
  
  public final long component10()
  {
    return this.duration;
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
    return this.fps;
  }
  
  public final long component5()
  {
    return this.ioCnt;
  }
  
  public final long component6()
  {
    return this.ioSize;
  }
  
  public final long component7()
  {
    return this.netRec;
  }
  
  public final long component8()
  {
    return this.netSend;
  }
  
  public final long component9()
  {
    return this.netPack;
  }
  
  @NotNull
  public final SceneMeta copy(@NotNull String paramString, double paramDouble, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "stage");
    return new SceneMeta(paramString, paramDouble, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8);
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
            if (this.fps == paramObject.fps) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              if (this.ioCnt == paramObject.ioCnt) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0)
              {
                if (this.ioSize == paramObject.ioSize) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (i != 0)
                {
                  if (this.netRec == paramObject.netRec) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  if (i != 0)
                  {
                    if (this.netSend == paramObject.netSend) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    if (i != 0)
                    {
                      if (this.netPack == paramObject.netPack) {
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
                }
              }
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
    l = this.fps;
    int m = (int)(l ^ l >>> 32);
    l = this.ioCnt;
    int n = (int)(l ^ l >>> 32);
    l = this.ioSize;
    int i1 = (int)(l ^ l >>> 32);
    l = this.netRec;
    int i2 = (int)(l ^ l >>> 32);
    l = this.netSend;
    int i3 = (int)(l ^ l >>> 32);
    l = this.netPack;
    int i4 = (int)(l ^ l >>> 32);
    l = this.duration;
    return ((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + (int)(l ^ l >>> 32);
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
    localStringBuilder.append(", fps=");
    localStringBuilder.append(this.fps);
    localStringBuilder.append(", ioCnt=");
    localStringBuilder.append(this.ioCnt);
    localStringBuilder.append(", ioSize=");
    localStringBuilder.append(this.ioSize);
    localStringBuilder.append(", netRec=");
    localStringBuilder.append(this.netRec);
    localStringBuilder.append(", netSend=");
    localStringBuilder.append(this.netSend);
    localStringBuilder.append(", netPack=");
    localStringBuilder.append(this.netPack);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.SceneMeta
 * JD-Core Version:    0.7.0.1
 */