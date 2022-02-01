package com.tencent.tgpa.vendorpd.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class d
{
  private static String a = "abcdef0123456789";
  private static String b = "1020304050607080";
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte[2048];
    MessageDigest localMessageDigest;
    try
    {
      paramFile = new FileInputStream(paramFile);
      localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramFile.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      System.out.println("error");
      return null;
    }
    paramFile = a(localMessageDigest.digest());
    return paramFile;
  }
  
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
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if (j < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Integer.toHexString(j));
      i += 1;
    }
    return localStringBuffer.toString();
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
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, new SecretKeySpec(a.getBytes("utf-8"), "AES"), new IvParameterSpec(b.getBytes("utf-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[paramString.length / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt("" + paramString[(i * 2)] + paramString[(i * 2 + 1)], 16));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(a.getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(b.getBytes("utf-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String d(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(c[(k >> 4 & 0xF)]);
      localStringBuilder.append(c[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.d
 * JD-Core Version:    0.7.0.1
 */