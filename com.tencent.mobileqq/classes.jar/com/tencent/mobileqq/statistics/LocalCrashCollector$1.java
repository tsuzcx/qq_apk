package com.tencent.mobileqq.statistics;

import java.io.File;
import java.io.FilenameFilter;

class LocalCrashCollector$1
  implements FilenameFilter
{
  LocalCrashCollector$1(LocalCrashCollector paramLocalCrashCollector) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.contains("CrashInfoSummary.txt") ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.1
 * JD-Core Version:    0.7.0.1
 */