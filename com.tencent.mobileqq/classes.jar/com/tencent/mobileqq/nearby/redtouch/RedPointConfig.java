package com.tencent.mobileqq.nearby.redtouch;

import java.io.Serializable;

public class RedPointConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int bindLevel;
  public int passThroughLevel;
  public int priority;
  public int redPointId;
  public int taskId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId");
    localStringBuilder.append(":");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append("|");
    localStringBuilder.append("redPointId:");
    localStringBuilder.append(this.redPointId);
    localStringBuilder.append("|");
    localStringBuilder.append("passThroughLevel:");
    localStringBuilder.append(this.passThroughLevel);
    localStringBuilder.append("|");
    localStringBuilder.append("bindLevel:");
    localStringBuilder.append(this.bindLevel);
    localStringBuilder.append("|");
    localStringBuilder.append("priority:");
    localStringBuilder.append(this.priority);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedPointConfig
 * JD-Core Version:    0.7.0.1
 */