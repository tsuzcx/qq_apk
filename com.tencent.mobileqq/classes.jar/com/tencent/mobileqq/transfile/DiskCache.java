package com.tencent.mobileqq.transfile;

import java.io.File;

public class DiskCache
{
  private static final String TAG = "DiskCache";
  File directory;
  
  public DiskCache(File paramFile)
  {
    this.directory = paramFile;
  }
  
  DiskCache.Editor edit(String paramString)
  {
    return new DiskCache.Editor(this, paramString);
  }
  
  File getCleanFile(String paramString)
  {
    if (!this.directory.exists()) {
      this.directory.mkdirs();
    }
    return new File(this.directory, paramString);
  }
  
  public File getDirectory()
  {
    return this.directory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DiskCache
 * JD-Core Version:    0.7.0.1
 */