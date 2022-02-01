package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

final class TbsShareManager$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return !paramFile.getName().endsWith(".dex");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager.1
 * JD-Core Version:    0.7.0.1
 */