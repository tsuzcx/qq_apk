package com.tencent.qqmini.sdk.core.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class DeviceUtil$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]+", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.DeviceUtil.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */