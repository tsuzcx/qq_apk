package com.tencent.qqperf.debug.tools;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class FileUtil
{
  public static long a = 0L;
  
  public static String a(String paramString)
  {
    Object localObject = new File(paramString);
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).getParent();
      long l = System.currentTimeMillis();
      String str = "out_" + String.valueOf(l) + ".zip";
      localObject = (String)localObject + "/" + str;
      a(paramString, (String)localObject);
      return localObject;
    }
    return "";
  }
  
  public static void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return FileUtils.f(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.tools.FileUtil
 * JD-Core Version:    0.7.0.1
 */