package com.tencent.qqcamerakit.common;

import java.io.File;
import java.io.IOException;

public class FileUtils
{
  public static File a(String paramString)
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
  
  public static void a(String paramString)
  {
    if (!a(paramString)) {}
    try
    {
      a(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */