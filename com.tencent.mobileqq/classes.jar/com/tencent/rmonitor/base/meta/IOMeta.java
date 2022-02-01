package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/IOMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "path", "", "fileSize", "", "opCnt", "", "bufferSize", "opCostTime", "opType", "opSize", "threadName", "processName", "stack", "timeStamp", "(Ljava/lang/String;JIJJIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getBufferSize", "()J", "getFileSize", "getOpCnt", "()I", "getOpCostTime", "getOpSize", "getOpType", "getPath", "()Ljava/lang/String;", "getProcessName", "getStack", "getThreadName", "getTimeStamp", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class IOMeta
  extends MonitorMeta
{
  private final long bufferSize;
  private final long fileSize;
  private final int opCnt;
  private final long opCostTime;
  private final long opSize;
  private final int opType;
  @NotNull
  private final String path;
  @NotNull
  private final String processName;
  @NotNull
  private final String stack;
  @NotNull
  private final String threadName;
  private final long timeStamp;
  
  public IOMeta(@NotNull String paramString1, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, long paramLong5)
  {
    this.path = paramString1;
    this.fileSize = paramLong1;
    this.opCnt = paramInt1;
    this.bufferSize = paramLong2;
    this.opCostTime = paramLong3;
    this.opType = paramInt2;
    this.opSize = paramLong4;
    this.threadName = paramString2;
    this.processName = paramString3;
    this.stack = paramString4;
    this.timeStamp = paramLong5;
  }
  
  @NotNull
  public final String component1()
  {
    return this.path;
  }
  
  @NotNull
  public final String component10()
  {
    return this.stack;
  }
  
  public final long component11()
  {
    return this.timeStamp;
  }
  
  public final long component2()
  {
    return this.fileSize;
  }
  
  public final int component3()
  {
    return this.opCnt;
  }
  
  public final long component4()
  {
    return this.bufferSize;
  }
  
  public final long component5()
  {
    return this.opCostTime;
  }
  
  public final int component6()
  {
    return this.opType;
  }
  
  public final long component7()
  {
    return this.opSize;
  }
  
  @NotNull
  public final String component8()
  {
    return this.threadName;
  }
  
  @NotNull
  public final String component9()
  {
    return this.processName;
  }
  
  @NotNull
  public final IOMeta copy(@NotNull String paramString1, long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, long paramLong5)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "path");
    Intrinsics.checkParameterIsNotNull(paramString2, "threadName");
    Intrinsics.checkParameterIsNotNull(paramString3, "processName");
    Intrinsics.checkParameterIsNotNull(paramString4, "stack");
    return new IOMeta(paramString1, paramLong1, paramInt1, paramLong2, paramLong3, paramInt2, paramLong4, paramString2, paramString3, paramString4, paramLong5);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof IOMeta))
      {
        paramObject = (IOMeta)paramObject;
        if (Intrinsics.areEqual(this.path, paramObject.path))
        {
          int i;
          if (this.fileSize == paramObject.fileSize) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.opCnt == paramObject.opCnt) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              if (this.bufferSize == paramObject.bufferSize) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0)
              {
                if (this.opCostTime == paramObject.opCostTime) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (i != 0)
                {
                  if (this.opType == paramObject.opType) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  if (i != 0)
                  {
                    if (this.opSize == paramObject.opSize) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    if ((i != 0) && (Intrinsics.areEqual(this.threadName, paramObject.threadName)) && (Intrinsics.areEqual(this.processName, paramObject.processName)) && (Intrinsics.areEqual(this.stack, paramObject.stack)))
                    {
                      if (this.timeStamp == paramObject.timeStamp) {
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
      return false;
    }
    return true;
  }
  
  public final long getBufferSize()
  {
    return this.bufferSize;
  }
  
  public final long getFileSize()
  {
    return this.fileSize;
  }
  
  public final int getOpCnt()
  {
    return this.opCnt;
  }
  
  public final long getOpCostTime()
  {
    return this.opCostTime;
  }
  
  public final long getOpSize()
  {
    return this.opSize;
  }
  
  public final int getOpType()
  {
    return this.opType;
  }
  
  @NotNull
  public final String getPath()
  {
    return this.path;
  }
  
  @NotNull
  public final String getProcessName()
  {
    return this.processName;
  }
  
  @NotNull
  public final String getStack()
  {
    return this.stack;
  }
  
  @NotNull
  public final String getThreadName()
  {
    return this.threadName;
  }
  
  public final long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public int hashCode()
  {
    String str = this.path;
    int m = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    long l = this.fileSize;
    int n = (int)(l ^ l >>> 32);
    int i1 = this.opCnt;
    l = this.bufferSize;
    int i2 = (int)(l ^ l >>> 32);
    l = this.opCostTime;
    int i3 = (int)(l ^ l >>> 32);
    int i4 = this.opType;
    l = this.opSize;
    int i5 = (int)(l ^ l >>> 32);
    str = this.threadName;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.processName;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.stack;
    if (str != null) {
      m = str.hashCode();
    }
    l = this.timeStamp;
    return (((((((((i * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IOMeta(path=");
    localStringBuilder.append(this.path);
    localStringBuilder.append(", fileSize=");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(", opCnt=");
    localStringBuilder.append(this.opCnt);
    localStringBuilder.append(", bufferSize=");
    localStringBuilder.append(this.bufferSize);
    localStringBuilder.append(", opCostTime=");
    localStringBuilder.append(this.opCostTime);
    localStringBuilder.append(", opType=");
    localStringBuilder.append(this.opType);
    localStringBuilder.append(", opSize=");
    localStringBuilder.append(this.opSize);
    localStringBuilder.append(", threadName=");
    localStringBuilder.append(this.threadName);
    localStringBuilder.append(", processName=");
    localStringBuilder.append(this.processName);
    localStringBuilder.append(", stack=");
    localStringBuilder.append(this.stack);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.IOMeta
 * JD-Core Version:    0.7.0.1
 */