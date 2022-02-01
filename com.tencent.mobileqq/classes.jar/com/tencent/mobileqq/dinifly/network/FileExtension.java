package com.tencent.mobileqq.dinifly.network;

import com.tencent.mobileqq.dinifly.L;

public enum FileExtension
{
  JSON(".json"),  ZIP(".zip");
  
  public final String extension;
  
  private FileExtension(String paramString)
  {
    this.extension = paramString;
  }
  
  public static FileExtension forFile(String paramString)
  {
    FileExtension[] arrayOfFileExtension = values();
    int j = arrayOfFileExtension.length;
    int i = 0;
    while (i < j)
    {
      FileExtension localFileExtension = arrayOfFileExtension[i];
      if (paramString.endsWith(localFileExtension.extension)) {
        return localFileExtension;
      }
      i += 1;
    }
    L.warn("Unable to find correct extension for " + paramString);
    return JSON;
  }
  
  public String tempExtension()
  {
    return ".temp" + this.extension;
  }
  
  public String toString()
  {
    return this.extension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.FileExtension
 * JD-Core Version:    0.7.0.1
 */