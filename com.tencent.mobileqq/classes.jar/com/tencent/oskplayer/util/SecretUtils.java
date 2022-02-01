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
  public static final String TAG = "SecretUtils";
  private static String sRandomStr = null;
  
  private static void appendHex(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF));
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public static String decode(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      int i = -1;
      if ((paramString1.hashCode() == 99346) && (paramString1.equals("des"))) {
        i = 0;
      }
      if (i == 0) {
        return decodeDes(paramString2, paramString3);
      }
    }
    return null;
  }
  
  private static String decodeDes(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() >= 8))
    {
      paramString2 = Base16.decode(paramString2);
      if ((paramString2 != null) && (paramString2.length != 0)) {
        try
        {
          long l = System.currentTimeMillis();
          localObject = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("start decode milles time = ");
          localStringBuilder.append(l);
          PlayerUtils.log(3, (String)localObject, localStringBuilder.toString());
          paramString1 = new DESKeySpec(paramString1.getBytes());
          paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
          localObject = Cipher.getInstance("DES/CBC/PKCS5Padding");
          ((Cipher)localObject).init(2, paramString1, new IvParameterSpec(DESIV));
          paramString1 = new String(((Cipher)localObject).doFinal(paramString2));
          paramString2 = TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("end decode milles time = ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          PlayerUtils.log(3, paramString2, ((StringBuilder)localObject).toString());
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString2 = TAG;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decode des error");
          ((StringBuilder)localObject).append(PlayerUtils.getPrintableStackTrace(paramString1));
          PlayerUtils.log(6, paramString2, ((StringBuilder)localObject).toString());
          throw paramString1;
        }
      }
      return null;
    }
    throw new Exception("secret key is not available");
  }
  
  public static String encode(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      int i = -1;
      if ((paramString1.hashCode() == 99346) && (paramString1.equals("des"))) {
        i = 0;
      }
      if (i == 0) {
        return encodeDes(paramString2, paramString3);
      }
    }
    return null;
  }
  
  private static String encodeDes(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() >= 8))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        try
        {
          long l = System.currentTimeMillis();
          localObject = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("start encode milles time = ");
          localStringBuilder.append(l);
          PlayerUtils.log(3, (String)localObject, localStringBuilder.toString());
          paramString1 = new DESKeySpec(paramString1.getBytes());
          paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
          localObject = Cipher.getInstance("DES/CBC/PKCS5Padding");
          ((Cipher)localObject).init(1, paramString1, new IvParameterSpec(DESIV));
          paramString1 = Base16.encode(((Cipher)localObject).doFinal(paramString2.getBytes()));
          paramString2 = TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("end encode milles time = ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          PlayerUtils.log(3, paramString2, ((StringBuilder)localObject).toString());
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString2 = TAG;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("encode des error");
          ((StringBuilder)localObject).append(PlayerUtils.getPrintableStackTrace(paramString1));
          PlayerUtils.log(6, paramString2, ((StringBuilder)localObject).toString());
          throw paramString1;
        }
      }
      return null;
    }
    throw new Exception("secret key is not available");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.SecretUtils
 * JD-Core Version:    0.7.0.1
 */