package com.tencent.tbs.one.impl.common.statistic;

import java.io.File;
import java.util.Comparator;

class LogPackingJob$1
  implements Comparator<File>
{
  LogPackingJob$1(LogPackingJob paramLogPackingJob) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    if (paramFile1.lastModified() < paramFile2.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.LogPackingJob.1
 * JD-Core Version:    0.7.0.1
 */