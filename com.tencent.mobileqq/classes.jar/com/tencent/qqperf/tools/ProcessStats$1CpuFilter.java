package com.tencent.qqperf.tools;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class ProcessStats$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]+", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.tools.ProcessStats.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */