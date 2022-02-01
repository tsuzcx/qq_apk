package com.tencent.mobileqq.shortvideo.util;

import java.io.File;

public class FileUtil
{
  public static boolean checkFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */