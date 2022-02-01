package com.tencent.mobileqq.vashealth;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TracePathData
  extends Entity
{
  public static final String TABLE_NAME = "TracePathData";
  public double distance;
  public long endTime;
  public int isStop;
  @unique
  public long startTime;
  public int stepsGoal;
  public int totalSteps;
  public long totalTime;
  public int type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTime: ");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append("endTime: ");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(",distance: ");
    localStringBuilder.append(this.distance);
    localStringBuilder.append(", totalTime: ");
    localStringBuilder.append(this.totalTime);
    localStringBuilder.append(", isStop: ");
    localStringBuilder.append(this.isStop);
    localStringBuilder.append(",totalSteps:");
    localStringBuilder.append(this.totalSteps);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.TracePathData
 * JD-Core Version:    0.7.0.1
 */