package com.tencent.mobileqq.triton.utils;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum LogDelegate$Level
{
  static
  {
    Level localLevel1 = new Level("VERBOSE", 0);
    VERBOSE = localLevel1;
    Level localLevel2 = new Level("DEBUG", 1);
    DEBUG = localLevel2;
    Level localLevel3 = new Level("INFO", 2);
    INFO = localLevel3;
    Level localLevel4 = new Level("WARN", 3);
    WARN = localLevel4;
    Level localLevel5 = new Level("ERROR", 4);
    ERROR = localLevel5;
    $VALUES = new Level[] { localLevel1, localLevel2, localLevel3, localLevel4, localLevel5 };
  }
  
  private LogDelegate$Level() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.LogDelegate.Level
 * JD-Core Version:    0.7.0.1
 */