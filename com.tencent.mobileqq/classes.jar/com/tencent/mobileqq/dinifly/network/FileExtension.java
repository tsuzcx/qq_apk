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
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      FileExtension localFileExtension = localObject[i];
      if (paramString.endsWith(localFileExtension.extension)) {
        return localFileExtension;
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to find correct extension for ");
    ((StringBuilder)localObject).append(paramString);
    L.warn(((StringBuilder)localObject).toString());
    return JSON;
  }
  
  public String tempExtension()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".temp");
    localStringBuilder.append(this.extension);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return this.extension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.FileExtension
 * JD-Core Version:    0.7.0.1
 */