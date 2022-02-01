package com.tencent.weiyun.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public final class Utils
{
  private static final String SP_NAME = "com.tencent.weiyun.pref.device_info";
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String getSpString(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return paramString2;
    }
    return paramContext.getSharedPreferences("com.tencent.weiyun.pref.device_info", 0).getString(paramString1, paramString2);
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    int j = 0;
    int k = paramString.length();
    if ((k & 0x1) != 0) {
      throw new RuntimeException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[k >> 1];
    int i = 0;
    while (j < k)
    {
      int m = j + 1;
      int n = Character.digit(paramString.charAt(j), 16);
      j = m + 1;
      arrayOfByte[i] = ((byte)((Character.digit(paramString.charAt(m), 16) | n << 4) & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String makeStringWithLength(String paramString, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    while (paramString.length() <= paramInt) {
      paramString.append(UUID.randomUUID().toString());
    }
    return paramString.substring(0, paramInt);
  }
  
  private static void saveSpString(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("com.tencent.weiyun.pref.device_info", 0);
    if (paramString2 == null)
    {
      paramContext.edit().remove(paramString1).commit();
      return;
    }
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public static byte[] str2Md5(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return paramString.getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.Utils
 * JD-Core Version:    0.7.0.1
 */