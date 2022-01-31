package com.tencent.mobileqq.transfile;

import java.io.File;

public class DiskCache
{
  File a;
  
  public DiskCache(File paramFile)
  {
    this.a = paramFile;
  }
  
  DiskCache.Editor a(String paramString)
  {
    return new DiskCache.Editor(this, paramString);
  }
  
  File a(String paramString)
  {
    if (!this.a.exists()) {
      this.a.mkdirs();
    }
    return new File(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DiskCache
 * JD-Core Version:    0.7.0.1
 */