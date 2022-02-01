package com.tencent.xweb.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.xwalk.core.Log;

public class a
{
  private static String a = "AESUtil";
  
  public static String a(String paramString, SecretKey paramSecretKey)
  {
    paramString = a(b(paramString), paramSecretKey);
    if (paramString == null) {
      return "";
    }
    return new String(paramString);
  }
  
  public static SecretKey a(String paramString)
  {
    try
    {
      paramString = new SecretKeySpec(b(paramString), "AES");
      return paramString;
    }
    catch (Throwable paramString)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("makekey exp:");
      localStringBuilder.append(paramString.getMessage());
      Log.e(str, localStringBuilder.toString());
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, SecretKey paramSecretKey)
  {
    try
    {
      paramSecretKey = new SecretKeySpec(paramSecretKey.getEncoded(), "AES");
      localObject = Cipher.getInstance("AES/ECB/PKCS5Padding");
      ((Cipher)localObject).init(2, paramSecretKey);
      paramArrayOfByte = ((Cipher)localObject).doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramSecretKey = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decrypt exp:");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      Log.e(paramSecretKey, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.a
 * JD-Core Version:    0.7.0.1
 */