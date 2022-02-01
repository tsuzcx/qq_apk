package com.tencent.mobileqq.triton.statistic;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/TraceStatistics;", "", "records", "", "Lcom/tencent/mobileqq/triton/statistic/TraceStatistics$Record;", "(Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Record", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class TraceStatistics
{
  @NotNull
  private final List<TraceStatistics.Record> records;
  
  public TraceStatistics(@NotNull List<TraceStatistics.Record> paramList)
  {
    this.records = paramList;
  }
  
  @NotNull
  public final List<TraceStatistics.Record> component1()
  {
    return this.records;
  }
  
  @NotNull
  public final TraceStatistics copy(@NotNull List<TraceStatistics.Record> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "records");
    return new TraceStatistics(paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TraceStatistics))
      {
        paramObject = (TraceStatistics)paramObject;
        if (Intrinsics.areEqual(this.records, paramObject.records)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final List<TraceStatistics.Record> getRecords()
  {
    return this.records;
  }
  
  public int hashCode()
  {
    List localList = this.records;
    if (localList != null) {
      return localList.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TraceStatistics(records=");
    localStringBuilder.append(this.records);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.TraceStatistics
 * JD-Core Version:    0.7.0.1
 */