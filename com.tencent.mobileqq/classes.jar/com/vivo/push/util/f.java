package com.vivo.push.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class f
{
  public static String a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((char)(paramArrayOfByte[i] ^ 0x10));
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString2 = new SecretKeySpec(paramString2.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, paramString2, new IvParameterSpec(paramString1.getBytes("utf-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.f
 * JD-Core Version:    0.7.0.1
 */