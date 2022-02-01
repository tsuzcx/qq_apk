package com.tencent.mtt.hippy.utils;

import java.security.MessageDigest;

public class MD5Utils
{
  public static String byteToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        if ((paramArrayOfByte[i] & 0xFF) < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Long.toString(paramArrayOfByte[i] & 0xFF, 16));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes();
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString);
      paramString = byteToHexString(((MessageDigest)localObject).digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMD5: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      LogUtils.d("MD5Utils", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static String getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = byteToHexString(((MessageDigest)localObject).digest());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMD5: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      LogUtils.d("MD5Utils", ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.MD5Utils
 * JD-Core Version:    0.7.0.1
 */