package com.tencent.mobileqq.flutter.launch;

import java.io.File;
import java.io.FilenameFilter;

final class DebugInstaller$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("res_timestamp-");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.DebugInstaller.1
 * JD-Core Version:    0.7.0.1
 */