package com.tencent.qqcamerakit.common;

import java.io.File;
import java.io.IOException;

public class FileUtils
{
  public static void a(String paramString)
  {
    if (!b(paramString)) {}
    try
    {
      c(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static File c(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */