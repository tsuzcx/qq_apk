package com.tencent.mobileqq.filemanager.discoperation;

import com.tencent.mobileqq.filemanager.api.IFileHttpUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class FileHttpUtils
{
  private static IFileHttpUtils a()
  {
    return (IFileHttpUtils)QRoute.api(IFileHttpUtils.class);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a().hexToString(paramArrayOfByte);
  }
  
  public static boolean a(int paramInt)
  {
    return a().isNeedRetryOtherUrl(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils
 * JD-Core Version:    0.7.0.1
 */