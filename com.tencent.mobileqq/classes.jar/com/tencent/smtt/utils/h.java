package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.stat.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class h
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static h b;
  private String c;
  private String d;
  private String e;
  
  private h()
  {
    int i = new Random().nextInt(89999999);
    int j = new Random().nextInt(89999999);
    this.e = String.valueOf(i + 10000000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append(String.valueOf(j + 10000000));
    this.c = localStringBuilder.toString();
  }
  
  public static h a()
  {
    try
    {
      if (b == null) {
        b = new h();
      }
      h localh = b;
      return localh;
    }
    finally {}
  }
  
  private String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = a;
      arrayOfChar1[k] = arrayOfChar2[(j >>> 4)];
      arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return a.a(this.e.getBytes(), paramArrayOfByte, 1);
  }
  
  public void b()
  {
    Security.addProvider((Provider)Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
  }
  
  public String c()
  {
    if (this.d == null)
    {
      byte[] arrayOfByte = this.c.getBytes();
      Object localObject = null;
      for (;;)
      {
        try
        {
          localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          localObject = localCipher;
        }
        catch (Exception localException2)
        {
          Cipher localCipher;
          X509EncodedKeySpec localX509EncodedKeySpec;
          continue;
        }
        try
        {
          b();
          localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
          localObject = localCipher;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0));
      localObject.init(1, KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec));
      this.d = b(localObject.doFinal(arrayOfByte));
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.h
 * JD-Core Version:    0.7.0.1
 */