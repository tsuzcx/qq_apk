package com.tencent.ttpic.baseutils.encrypt;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtil
{
  private static final String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  private static String byteToArrayString(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    return strDigits[paramByte] + strDigits[(i % 16)];
  }
  
  private static String byteToString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(byteToArrayString(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public String desCrypto(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      paramString = new DESKeySpec(paramString.getBytes());
      paramString = SecretKeyFactory.getInstance("DES").generateSecret(paramString);
      Cipher localCipher = Cipher.getInstance("DES");
      localCipher.init(1, paramString, localSecureRandom);
      paramArrayOfByte = byteToString(localCipher.doFinal(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      LogUtils.e(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.encrypt.DESUtil
 * JD-Core Version:    0.7.0.1
 */