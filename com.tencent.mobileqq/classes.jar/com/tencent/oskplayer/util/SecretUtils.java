package com.tencent.oskplayer.util;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class SecretUtils
{
  public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
  public static final String DES = "des";
  private static final byte[] DESIV = { 18, 52, 86, 120, -112, -85, -51, -17 };
  private static final String HEX = "0123456789ABCDEF";
  private static final String SHA1PRNG = "SHA1PRNG";
  public static final String TAG = SecretUtils.class.getSimpleName();
  private static String sRandomStr = null;
  
  private static void appendHex(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public static String decode(String paramString1, String paramString2, String paramString3)
  {
    int i;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      i = -1;
      switch (paramString1.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramString1.equals("des")) {
          i = 0;
        }
        break;
      }
    }
    return decodeDes(paramString2, paramString3);
  }
  
  private static String decodeDes(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() < 8)) {
      throw new Exception("secret key is not available");
    }
    paramString2 = Base16.decode(paramString2);
    if ((paramString2 == null) || (paramString2.length == 0)) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      PlayerUtils.log(3, TAG, "start decode milles time = " + l);
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString1, new IvParameterSpec(DESIV));
      paramString1 = new String(localCipher.doFinal(paramString2));
      PlayerUtils.log(3, TAG, "end decode milles time = " + (System.currentTimeMillis() - l));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      PlayerUtils.log(6, TAG, "decode des error" + PlayerUtils.getPrintableStackTrace(paramString1));
      throw paramString1;
    }
  }
  
  public static String encode(String paramString1, String paramString2, String paramString3)
  {
    int i;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      i = -1;
      switch (paramString1.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramString1.equals("des")) {
          i = 0;
        }
        break;
      }
    }
    return encodeDes(paramString2, paramString3);
  }
  
  private static String encodeDes(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() < 8)) {
      throw new Exception("secret key is not available");
    }
    if ((paramString2 == null) || (paramString2.isEmpty())) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      PlayerUtils.log(3, TAG, "start encode milles time = " + l);
      paramString1 = new DESKeySpec(paramString1.getBytes());
      paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString1, new IvParameterSpec(DESIV));
      paramString1 = Base16.encode(localCipher.doFinal(paramString2.getBytes()));
      PlayerUtils.log(3, TAG, "end encode milles time = " + (System.currentTimeMillis() - l));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      PlayerUtils.log(6, TAG, "encode des error" + PlayerUtils.getPrintableStackTrace(paramString1));
      throw paramString1;
    }
  }
  
  public static String generateKey()
  {
    try
    {
      Object localObject = SecureRandom.getInstance("SHA1PRNG");
      byte[] arrayOfByte = new byte[20];
      ((SecureRandom)localObject).nextBytes(arrayOfByte);
      localObject = toHex(arrayOfByte);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String getRandomNum()
  {
    try
    {
      if (sRandomStr == null) {
        sRandomStr = generateKey();
      }
      String str = sRandomStr;
      return str;
    }
    finally {}
  }
  
  public static String toHex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      appendHex(localStringBuffer, paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.util.SecretUtils
 * JD-Core Version:    0.7.0.1
 */