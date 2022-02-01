package com.tencent.tbs.one.impl.policy;

import java.io.File;
import java.io.FileFilter;

final class InstallationUtils$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.isDirectory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.InstallationUtils.1
 * JD-Core Version:    0.7.0.1
 */