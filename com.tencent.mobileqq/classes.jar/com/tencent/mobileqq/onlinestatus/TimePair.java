package com.tencent.mobileqq.onlinestatus;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/TimePair;", "", "interval", "", "updateTimeSec", "(JJ)V", "getInterval", "()J", "setInterval", "(J)V", "getUpdateTimeSec", "setUpdateTimeSec", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class TimePair
{
  private long a;
  private long b;
  
  public TimePair()
  {
    this(0L, 0L, 3, null);
  }
  
  public TimePair(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TimePair))
      {
        paramObject = (TimePair)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b)) {}
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
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimePair(interval=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", updateTimeSec=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.TimePair
 * JD-Core Version:    0.7.0.1
 */