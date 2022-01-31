package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.stat.DesUtils;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class PostEncryption
{
  private static final char[] HEXARRAY = "0123456789abcdef".toCharArray();
  private static final String PUBLICKEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==";
  private static final String RSA_NO_PADDING = "RSA/ECB/NoPadding";
  private static PostEncryption mInstance;
  private String mDesKeyStr;
  private String mRsaKeyStr;
  private String mRsaKeyStrTemp;
  
  private PostEncryption()
  {
    int i = new Random().nextInt(89999999);
    int j = new Random().nextInt(89999999);
    this.mDesKeyStr = String.valueOf(i + 10000000);
    this.mRsaKeyStrTemp = (this.mDesKeyStr + String.valueOf(j + 10000000));
  }
  
  private String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = HEXARRAY[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = HEXARRAY[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static PostEncryption getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new PostEncryption();
      }
      PostEncryption localPostEncryption = mInstance;
      return localPostEncryption;
    }
    finally {}
  }
  
  public byte[] DESDecrypt(byte[] paramArrayOfByte)
  {
    return DesUtils.DesEncrypt(this.mDesKeyStr.getBytes(), paramArrayOfByte, 0);
  }
  
  public byte[] DESEncrypt(byte[] paramArrayOfByte)
  {
    return DesUtils.DesEncrypt(this.mDesKeyStr.getBytes(), paramArrayOfByte, 1);
  }
  
  public String RSAEncode(String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes();
    paramString = null;
    try
    {
      localObject = Cipher.getInstance("RSA/ECB/NoPadding");
      paramString = (String)localObject;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          addBouncyCastleProvider();
          Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          paramString = localCipher;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    localObject = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
    paramString.init(1, KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject));
    return bytesToHex(paramString.doFinal(arrayOfByte));
  }
  
  public void addBouncyCastleProvider()
  {
    Security.addProvider((Provider)Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
  }
  
  public String initRSAKey()
  {
    byte[] arrayOfByte;
    if (this.mRsaKeyStr == null)
    {
      arrayOfByte = this.mRsaKeyStrTemp.getBytes();
      localObject1 = null;
    }
    try
    {
      localObject2 = Cipher.getInstance("RSA/ECB/NoPadding");
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          addBouncyCastleProvider();
          Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          localObject1 = localCipher;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    localObject2 = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
    localObject1.init(1, KeyFactory.getInstance("RSA").generatePublic((KeySpec)localObject2));
    this.mRsaKeyStr = bytesToHex(localObject1.doFinal(arrayOfByte));
    return this.mRsaKeyStr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.PostEncryption
 * JD-Core Version:    0.7.0.1
 */