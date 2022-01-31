package com.tencent.qphone.base.util.a.a;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class b
{
  private static final String a = "RSA";
  
  static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new X509EncodedKeySpec(a(paramString2));
      paramString1 = paramString1.getBytes("UTF-8");
      Object localObject = KeyFactory.getInstance("RSA");
      paramString2 = ((KeyFactory)localObject).generatePublic(paramString2);
      localObject = Cipher.getInstance(((KeyFactory)localObject).getAlgorithm());
      ((Cipher)localObject).init(1, paramString2);
      paramString1 = a(((Cipher)localObject).doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a.a(paramArrayOfByte);
  }
  
  private static byte[] a(String paramString)
  {
    try
    {
      paramString = a.a(paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.a.b
 * JD-Core Version:    0.7.0.1
 */