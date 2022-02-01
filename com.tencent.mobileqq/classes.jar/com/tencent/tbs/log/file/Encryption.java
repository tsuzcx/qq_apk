package com.tencent.tbs.log.file;

import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption
{
  public static final String DEFAULT_TEXT_ENCODING = "UTF-8";
  public static final String LOG_ENCRYPTION_ALGORITHM = "RC4";
  
  public static String createKeyOfPlainText()
  {
    return String.valueOf(System.currentTimeMillis());
  }
  
  private static byte[] encryptKey(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private static byte[] encryptPlainText(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramString1.getBytes("UTF-8"), "RC4"));
      paramString1 = localCipher.update(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] getEncryptedKeyBytes(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = encryptKey(paramString1, paramString2);
      if (paramString1 == null) {
        return null;
      }
      paramString2 = String.format(Locale.US, "%03d", new Object[] { Integer.valueOf(paramString1.length) });
      byte[] arrayOfByte = new byte[paramString1.length + 3];
      arrayOfByte[0] = ((byte)paramString2.charAt(0));
      arrayOfByte[1] = ((byte)paramString2.charAt(1));
      arrayOfByte[2] = ((byte)paramString2.charAt(2));
      System.arraycopy(paramString1, 0, arrayOfByte, 3, paramString1.length);
      return arrayOfByte;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] getEncryptedLogBytes(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = encryptPlainText(paramString1, paramString2);
      if (paramString1 != null)
      {
        paramString2 = new byte[paramArrayOfByte.length + paramString1.length + 2];
        byte[] arrayOfByte = new byte[2];
        arrayOfByte[0] = 10;
        arrayOfByte[1] = 10;
        System.arraycopy(paramArrayOfByte, 0, paramString2, 0, paramArrayOfByte.length);
        int i = paramArrayOfByte.length + 0;
        System.arraycopy(paramString1, 0, paramString2, i, paramString1.length);
        System.arraycopy(arrayOfByte, 0, paramString2, i + paramString1.length, arrayOfByte.length);
        return paramString2;
      }
      paramString1 = paramString2.getBytes();
      return paramString1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.log.file.Encryption
 * JD-Core Version:    0.7.0.1
 */