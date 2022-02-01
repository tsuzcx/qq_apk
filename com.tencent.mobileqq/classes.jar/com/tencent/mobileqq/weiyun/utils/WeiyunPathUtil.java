package com.tencent.mobileqq.weiyun.utils;

import java.io.File;
import mqq.app.MobileQQ;

public class WeiyunPathUtil
{
  private static String a;
  private static String b;
  
  public static String a()
  {
    Object localObject1 = a;
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = MobileQQ.sMobileQQ.getExternalFilesDir(null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MobileQQ.sMobileQQ.getFilesDir();
    }
    localObject2 = ((File)localObject1).getAbsolutePath();
    localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    a = (String)localObject1;
    return localObject1;
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramLong));
    localStringBuilder.append("disk_file_cache");
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public static String b()
  {
    String str = b;
    if (str != null) {
      return str;
    }
    str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("Tencent");
    localStringBuilder.append("/");
    localStringBuilder.append("weiyun");
    localStringBuilder.append("/");
    str = localStringBuilder.toString();
    b = str;
    return str;
  }
  
  private static String b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(paramLong);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.WeiyunPathUtil
 * JD-Core Version:    0.7.0.1
 */