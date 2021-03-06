package com.tencent.qapmsdk.resource;

import android.os.Process;

public class ResourceCollectorConstant
{
  public static final int IMMEDIATE_SIZE = 900;
  static final int MANUAL_SIZE = 100;
  public static final int MAX_REPORT_COUNT = 3;
  public static final int MAX_STORE_FILE = 10;
  static final String PID_REG;
  static final String SYS_REG = "(\\d+)%user\\s+(\\d+)%nice\\s+(\\d+)%sys";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("^");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("\\s+");
    PID_REG = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.ResourceCollectorConstant
 * JD-Core Version:    0.7.0.1
 */