package com.tencent.ttpic.openapi.initializer;

import android.support.annotation.NonNull;

public class AEResourceInfo
{
  public String fileName;
  public int fileSizeBytes;
  public String sha1;
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public int getFileSizeInBytes()
  {
    return this.fileSizeBytes;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("%s(%s)", new Object[] { this.fileName, this.sha1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.AEResourceInfo
 * JD-Core Version:    0.7.0.1
 */