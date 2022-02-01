package com.tencent.tbs.log.file.clean;

import java.io.File;

public class FileLastModifiedCleanStrategy
  implements CleanStrategy
{
  private long maxTimeMillis;
  
  public FileLastModifiedCleanStrategy(long paramLong)
  {
    this.maxTimeMillis = paramLong;
  }
  
  public boolean shouldClean(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - paramFile.lastModified() > this.maxTimeMillis) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.log.file.clean.FileLastModifiedCleanStrategy
 * JD-Core Version:    0.7.0.1
 */