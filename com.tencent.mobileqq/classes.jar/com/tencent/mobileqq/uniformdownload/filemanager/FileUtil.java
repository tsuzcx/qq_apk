package com.tencent.mobileqq.uniformdownload.filemanager;

import java.io.File;

public class FileUtil
{
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename"))
    {
      paramString = paramString.replace(".rename", "");
      i = paramString.lastIndexOf(".");
      if (i == -1) {
        return ".rename";
      }
      return paramString.substring(i) + ".rename";
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return "";
    }
    return paramString.substring(i);
  }
  
  public static boolean a(String paramString)
  {
    return true;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i < 0);
    return paramString.substring(0, i + 1);
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.FileUtil
 * JD-Core Version:    0.7.0.1
 */