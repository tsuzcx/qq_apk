package com.tencent.mobileqq.shortvideo.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class ShortVideoTrimmer$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */