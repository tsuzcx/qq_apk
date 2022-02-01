package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.StatPolicy;

public class StatValue
{
  public int count;
  public StatPolicy policy;
  public float value;
  
  public StatValue(float paramFloat, int paramInt, StatPolicy paramStatPolicy)
  {
    this.value = paramFloat;
    this.count = paramInt;
    this.policy = paramStatPolicy;
  }
  
  public static StatValue create(float paramFloat, StatPolicy paramStatPolicy)
  {
    return new StatValue(paramFloat, 1, paramStatPolicy);
  }
  
  public static StatValue create(int paramInt, StatPolicy paramStatPolicy)
  {
    return new StatValue(paramInt, 1, paramStatPolicy);
  }
  
  public static StatValue create(long paramLong, StatPolicy paramStatPolicy)
  {
    return new StatValue((float)paramLong, 1, paramStatPolicy);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof StatValue))
    {
      paramObject = (StatValue)paramObject;
      if ((paramObject.count == this.count) && (paramObject.value == this.value) && (paramObject.policy == this.policy)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("policy=");
    localStringBuilder.append(this.policy);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.count);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfm.metrics.StatValue
 * JD-Core Version:    0.7.0.1
 */