package com.tencent.tbs.log.file.clean;

import java.io.File;

public class NeverCleanStrategy
  implements CleanStrategy
{
  public boolean shouldClean(File paramFile)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.log.file.clean.NeverCleanStrategy
 * JD-Core Version:    0.7.0.1
 */