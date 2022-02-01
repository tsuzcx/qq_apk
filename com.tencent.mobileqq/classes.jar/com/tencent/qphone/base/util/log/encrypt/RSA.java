package com.tencent.qphone.base.util.log.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RSA
{
  private static final String KEY_RSA = "RSA";
  
  private static byte[] decryptBase64(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String encryptBase64(byte[] paramArrayOfByte)
  {
    return Base64.encode(paramArrayOfByte);
  }
  
  static String encryptByPublic(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new X509EncodedKeySpec(decryptBase64(paramString2));
      paramString1 = paramString1.getBytes("UTF-8");
      Object localObject = KeyFactory.getInstance("RSA");
      paramString2 = ((KeyFactory)localObject).generatePublic(paramString2);
      localObject = Cipher.getInstance(((KeyFactory)localObject).getAlgorithm());
      ((Cipher)localObject).init(1, paramString2);
      paramString1 = encryptBase64(((Cipher)localObject).doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.encrypt.RSA
 * JD-Core Version:    0.7.0.1
 */