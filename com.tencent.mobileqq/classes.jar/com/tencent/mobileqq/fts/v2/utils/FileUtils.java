package com.tencent.mobileqq.fts.v2.utils;

import java.io.File;

public class FileUtils
{
  public static void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (paramFile.exists()) {
        return;
      }
      paramFile = paramFile.getParentFile();
      if ((paramFile != null) && (!paramFile.exists()))
      {
        a(paramFile);
        paramFile.mkdirs();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */