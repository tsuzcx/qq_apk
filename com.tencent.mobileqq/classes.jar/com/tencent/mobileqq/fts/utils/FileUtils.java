package com.tencent.mobileqq.fts.utils;

import java.io.File;

public class FileUtils
{
  public static void a(File paramFile)
  {
    if ((paramFile == null) || (paramFile.exists())) {}
    do
    {
      return;
      paramFile = paramFile.getParentFile();
    } while ((paramFile == null) || (paramFile.exists()));
    a(paramFile);
    paramFile.mkdirs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fts.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */