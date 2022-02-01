package com.tencent.mobileqq.kandian.repo.aladdin.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;

public class OccasionRule
  implements AladdinConfigBean
{
  private int baseDelayMs = 10000;
  private int debounceIntervalMinutes = 60;
  private int maximumWakeUpTimes = 3;
  private int randomDelayUpperBound = 10000;
  
  public int getBaseDelayMs()
  {
    return this.baseDelayMs;
  }
  
  public int getDebounceIntervalMinutes()
  {
    return this.debounceIntervalMinutes;
  }
  
  public int getMaximumWakeUpTimes()
  {
    return this.maximumWakeUpTimes;
  }
  
  public int getRandomDelayUpperBound()
  {
    return this.randomDelayUpperBound;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OccasionRule{baseDelayMs=");
    localStringBuilder.append(this.baseDelayMs);
    localStringBuilder.append(", debounceIntervalMinutes=");
    localStringBuilder.append(this.debounceIntervalMinutes);
    localStringBuilder.append(", maximumWakeUpTimes=");
    localStringBuilder.append(this.maximumWakeUpTimes);
    localStringBuilder.append(", randomDelayUpperBound=");
    localStringBuilder.append(this.randomDelayUpperBound);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.beans.OccasionRule
 * JD-Core Version:    0.7.0.1
 */