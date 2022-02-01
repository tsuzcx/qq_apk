package com.tencent.smtt.utils;

import java.io.File;

final class FileUtil$2
  implements FileUtil.a
{
  public boolean a(File paramFile1, File paramFile2)
  {
    return (paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil.2
 * JD-Core Version:    0.7.0.1
 */