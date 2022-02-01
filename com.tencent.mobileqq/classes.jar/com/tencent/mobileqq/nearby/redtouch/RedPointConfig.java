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
    localStringBuilder.append("taskId").append(":").append(this.taskId);
    localStringBuilder.append("|").append("redPointId:").append(this.redPointId);
    localStringBuilder.append("|").append("passThroughLevel:").append(this.passThroughLevel);
    localStringBuilder.append("|").append("bindLevel:").append(this.bindLevel);
    localStringBuilder.append("|").append("priority:").append(this.priority);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedPointConfig
 * JD-Core Version:    0.7.0.1
 */