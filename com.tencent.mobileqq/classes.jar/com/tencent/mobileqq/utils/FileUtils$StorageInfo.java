package com.tencent.mobileqq.utils;

public class FileUtils$StorageInfo
{
  public boolean isRemoveable;
  public String path;
  public String state;
  
  public FileUtils$StorageInfo(String paramString)
  {
    this.path = paramString;
  }
  
  public boolean isMounted()
  {
    return "mounted".equals(this.state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils.StorageInfo
 * JD-Core Version:    0.7.0.1
 */