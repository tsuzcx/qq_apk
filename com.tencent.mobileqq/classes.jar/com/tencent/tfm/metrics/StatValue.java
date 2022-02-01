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
    return ((paramObject instanceof StatValue)) && (((StatValue)paramObject).count == this.count) && (((StatValue)paramObject).value == this.value) && (((StatValue)paramObject).policy == this.policy);
  }
  
  public String toString()
  {
    return "policy=" + this.policy + ", value=" + this.value + ", count=" + this.count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.StatValue
 * JD-Core Version:    0.7.0.1
 */