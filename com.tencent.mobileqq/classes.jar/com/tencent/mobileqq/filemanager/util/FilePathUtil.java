package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class FilePathUtil
{
  private static IFilePathUtil a()
  {
    return (IFilePathUtil)QRoute.api(IFilePathUtil.class);
  }
  
  public static String a(String paramString)
  {
    return a().copyImageFileToMediaStorage(paramString);
  }
  
  public static boolean a(String paramString)
  {
    return a().fileExistsAndNotEmpty(paramString);
  }
  
  public static String b(String paramString)
  {
    return a().getRealPath(paramString);
  }
  
  public static String c(String paramString)
  {
    return a().renameImageFileToMediaStorage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FilePathUtil
 * JD-Core Version:    0.7.0.1
 */