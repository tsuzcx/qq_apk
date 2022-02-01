package com.tencent.mobileqq.mini.util;

import java.io.File;
import java.io.FileFilter;

final class DeviceInfoUtil$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    if (paramFile.startsWith("cpu"))
    {
      int i = 3;
      while (i < paramFile.length()) {
        if (paramFile.charAt(i) >= '0')
        {
          if (paramFile.charAt(i) > '9') {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.DeviceInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */