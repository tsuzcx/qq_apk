package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/FirstFrameStatistic;", "", "firstRenderTimeMs", "", "drawCallCount", "(JJ)V", "getDrawCallCount", "()J", "getFirstRenderTimeMs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class FirstFrameStatistic
{
  private final long drawCallCount;
  private final long firstRenderTimeMs;
  
  public FirstFrameStatistic(long paramLong1, long paramLong2)
  {
    this.firstRenderTimeMs = paramLong1;
    this.drawCallCount = paramLong2;
  }
  
  public final long component1()
  {
    return this.firstRenderTimeMs;
  }
  
  public final long component2()
  {
    return this.drawCallCount;
  }
  
  @NotNull
  public final FirstFrameStatistic copy(long paramLong1, long paramLong2)
  {
    return new FirstFrameStatistic(paramLong1, paramLong2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FirstFrameStatistic))
      {
        paramObject = (FirstFrameStatistic)paramObject;
        if ((this.firstRenderTimeMs == paramObject.firstRenderTimeMs) && (this.drawCallCount == paramObject.drawCallCount)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getDrawCallCount()
  {
    return this.drawCallCount;
  }
  
  public final long getFirstRenderTimeMs()
  {
    return this.firstRenderTimeMs;
  }
  
  public int hashCode()
  {
    long l = this.firstRenderTimeMs;
    int i = (int)(l ^ l >>> 32);
    l = this.drawCallCount;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FirstFrameStatistic(firstRenderTimeMs=");
    localStringBuilder.append(this.firstRenderTimeMs);
    localStringBuilder.append(", drawCallCount=");
    localStringBuilder.append(this.drawCallCount);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.FirstFrameStatistic
 * JD-Core Version:    0.7.0.1
 */