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
    localStringBuilder.append("startTime: ").append(this.startTime).append("endTime: ").append(this.endTime).append(",distance: ").append(this.distance).append(", totalTime: ").append(this.totalTime).append(", isStop: ").append(this.isStop).append(",totalSteps:").append(this.totalSteps);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.TracePathData
 * JD-Core Version:    0.7.0.1
 */