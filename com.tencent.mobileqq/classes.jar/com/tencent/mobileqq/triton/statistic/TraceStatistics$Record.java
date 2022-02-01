package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/TraceStatistics$Record;", "", "name", "", "timeUs", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTimeUs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class TraceStatistics$Record
{
  @NotNull
  private final String name;
  private final long timeUs;
  
  public TraceStatistics$Record(@NotNull String paramString, long paramLong)
  {
    this.name = paramString;
    this.timeUs = paramLong;
  }
  
  @NotNull
  public final String component1()
  {
    return this.name;
  }
  
  public final long component2()
  {
    return this.timeUs;
  }
  
  @NotNull
  public final Record copy(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return new Record(paramString, paramLong);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Record))
      {
        paramObject = (Record)paramObject;
        if ((Intrinsics.areEqual(this.name, paramObject.name)) && (this.timeUs == paramObject.timeUs)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public final long getTimeUs()
  {
    return this.timeUs;
  }
  
  public int hashCode()
  {
    String str = this.name;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    long l = this.timeUs;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Record(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", timeUs=");
    localStringBuilder.append(this.timeUs);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.TraceStatistics.Record
 * JD-Core Version:    0.7.0.1
 */