package com.tencent.rmonitor.resource.collector;

import android.os.Process;

public class ResourceCollectorConstant
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("^");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("\\s+");
    a = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.ResourceCollectorConstant
 * JD-Core Version:    0.7.0.1
 */