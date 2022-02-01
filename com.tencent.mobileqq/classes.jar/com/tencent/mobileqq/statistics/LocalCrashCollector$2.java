package com.tencent.mobileqq.statistics;

import java.io.File;
import java.util.Comparator;

class LocalCrashCollector$2
  implements Comparator<File>
{
  LocalCrashCollector$2(LocalCrashCollector paramLocalCrashCollector) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.2
 * JD-Core Version:    0.7.0.1
 */