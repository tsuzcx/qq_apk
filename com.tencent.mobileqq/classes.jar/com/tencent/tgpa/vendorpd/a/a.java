package com.tencent.tgpa.vendorpd.a;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static String a = "abcdef0123456789";
  private static String b = "1020304050607080";
  
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("utf-8"));
      paramString = b(new BigInteger(1, localMessageDigest.digest()).toString(16));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, new SecretKeySpec(a.getBytes("utf-8"), "AES"), new IvParameterSpec(b.getBytes("utf-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String b(String paramString)
  {
    if (paramString.length() == 32) {
      return paramString;
    }
    return b("0" + paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(a.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(b.getBytes("utf-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.a
 * JD-Core Version:    0.7.0.1
 */