package com.tencent.qqperf.debug.tools;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class FileUtil
{
  public static long a;
  
  public static String a(String paramString)
  {
    Object localObject1 = new File(paramString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).getParent();
      long l = System.currentTimeMillis();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("out_");
      ((StringBuilder)localObject2).append(String.valueOf(l));
      ((StringBuilder)localObject2).append(".zip");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("/");
      localStringBuilder.append((String)localObject2);
      localObject1 = localStringBuilder.toString();
      a(paramString, (String)localObject1);
      return localObject1;
    }
    return "";
  }
  
  public static void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
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
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return FileUtils.zipFiles(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.debug.tools.FileUtil
 * JD-Core Version:    0.7.0.1
 */