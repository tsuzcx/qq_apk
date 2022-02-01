package com.tencent.mtt.abtestsdk.utils;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RSAUtil
{
  private static final String DEFAULT_CIPHER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
  private static final String ENCRYPT_ALGORITHM = "RSA";
  private static final int MAX_DECRYPT_BLOCK = 128;
  private static final int MAX_ENCRYPT_BLOCK = 117;
  private static RSAPublicKey mLogPublicKey;
  
  public static String decrypt(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramPrivateKey);
    byte[] arrayOfByte = Base64.decode(paramArrayOfByte, 0);
    int k = arrayOfByte.length;
    paramPrivateKey = new ByteArrayOutputStream();
    int i = 0;
    int j = 0;
    for (;;)
    {
      int m = k - i;
      if (m <= 0) {
        break;
      }
      if (m > 128) {
        paramArrayOfByte = localCipher.doFinal(arrayOfByte, i, 128);
      } else {
        paramArrayOfByte = localCipher.doFinal(arrayOfByte, i, m);
      }
      paramPrivateKey.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      j += 1;
      i = j * 128;
    }
    paramArrayOfByte = paramPrivateKey.toByteArray();
    paramPrivateKey.close();
    return new String(paramArrayOfByte, "UTF-8");
  }
  
  public static String encrypt(byte[] paramArrayOfByte)
  {
    Object localObject = getWUPRSAPublicKey();
    if (paramArrayOfByte != null)
    {
      if (localObject == null) {
        return null;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, (Key)localObject);
        int k = paramArrayOfByte.length;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int j = 0;
        for (;;)
        {
          int m = k - i;
          if (m <= 0) {
            break;
          }
          if (m > 117) {
            localObject = localCipher.doFinal(paramArrayOfByte, i, 117);
          } else {
            localObject = localCipher.doFinal(paramArrayOfByte, i, m);
          }
          localByteArrayOutputStream.write((byte[])localObject, 0, localObject.length);
          j += 1;
          i = j * 117;
        }
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 2), "UTF-8");
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      catch (Error paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static String encrypt(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    if ((paramArrayOfByte != null) && (paramPublicKey != null))
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, paramPublicKey);
      int k = paramArrayOfByte.length;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      int j = 0;
      for (;;)
      {
        int m = k - i;
        if (m <= 0) {
          break;
        }
        if (m > 117) {
          paramPublicKey = localCipher.doFinal(paramArrayOfByte, i, 117);
        } else {
          paramPublicKey = localCipher.doFinal(paramArrayOfByte, i, m);
        }
        localByteArrayOutputStream.write(paramPublicKey, 0, paramPublicKey.length);
        j += 1;
        i = j * 117;
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return new String(Base64.encode(paramArrayOfByte, 0), "utf-8");
    }
    return null;
  }
  
  public static PrivateKey getPrivateKey(String paramString)
  {
    return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(paramString.getBytes("UTF-8"), 0)));
  }
  
  public static PublicKey getPublicKey(String paramString)
  {
    return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(paramString.getBytes("UTF-8"), 0)));
  }
  
  private static RSAPublicKey getWUPRSAPublicKey()
  {
    if (mLogPublicKey == null) {
      try
      {
        X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLhKbpjQQUFgVs0xX8mELVU8oFwUBIAcmtZf4FmvjkPXwtBwTkqHY2jhwr4ZRgyfGNl2537AssBA+jV2JSHlcRHeGOfR1ijueU5NojoUayvdJb5AyYI1y+OaonUgVSBHvl4Kwj04yc+6+bDp4ZAAM1Z5T50sovA0wL8pnNWEKU7QIDAQAB".getBytes("UTF-8"), 0));
        mLogPublicKey = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ABTestLog.error(localUnsupportedEncodingException.getMessage(), new Object[0]);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        ABTestLog.error(localNoSuchAlgorithmException.getMessage(), new Object[0]);
      }
      catch (InvalidKeySpecException localInvalidKeySpecException)
      {
        ABTestLog.error(localInvalidKeySpecException.getMessage(), new Object[0]);
      }
    }
    return mLogPublicKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.RSAUtil
 * JD-Core Version:    0.7.0.1
 */