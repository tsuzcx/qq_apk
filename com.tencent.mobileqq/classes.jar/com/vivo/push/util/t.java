package com.vivo.push.util;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public final class t
{
  private static String a = "RSA";
  
  public static PublicKey a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 2);
      paramString = KeyFactory.getInstance(a).generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      break label46;
    }
    catch (InvalidKeySpecException paramString)
    {
      break label36;
    }
    catch (NullPointerException paramString)
    {
      label26:
      label36:
      label46:
      break label26;
    }
    throw new Exception("公钥数据为空");
    throw new Exception("公钥非法");
    throw new Exception("无此算法");
  }
  
  public static boolean a(byte[] paramArrayOfByte1, PublicKey paramPublicKey, byte[] paramArrayOfByte2)
  {
    Signature localSignature = Signature.getInstance("MD5withRSA");
    localSignature.initVerify(paramPublicKey);
    localSignature.update(paramArrayOfByte1);
    return localSignature.verify(paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.t
 * JD-Core Version:    0.7.0.1
 */