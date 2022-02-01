package com.tencent.mobileqq.openapi.entity;

import com.tencent.mobileqq.openapi.ThirdAppConfigHelper.ThirdAppConfig;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;

public class ThirdPartyApp
{
  public String a;
  public String b;
  public long c;
  public long d = 0L;
  public int e;
  public String f;
  private byte[] g;
  private byte[] h;
  private int i;
  private int j;
  private int k;
  private int l;
  private Cryptor m;
  
  public ThirdPartyApp(ThirdAppConfigHelper.ThirdAppConfig paramThirdAppConfig)
  {
    this.a = paramThirdAppConfig.a;
    this.b = paramThirdAppConfig.c;
    this.e = paramThirdAppConfig.e;
    this.k = paramThirdAppConfig.f;
    this.l = paramThirdAppConfig.g;
    if (paramThirdAppConfig.j)
    {
      this.c = paramThirdAppConfig.l;
      this.g = a(paramThirdAppConfig.k);
      this.d = paramThirdAppConfig.i;
      this.h = a(paramThirdAppConfig.h);
      return;
    }
    this.c = paramThirdAppConfig.i;
    this.g = a(paramThirdAppConfig.h);
  }
  
  private byte[] a(long paramLong)
  {
    for (Object localObject1 = this.a; ((String)localObject1).length() < 16; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    Object localObject2 = ((String)localObject1).getBytes();
    byte[] arrayOfByte = String.valueOf(paramLong).getBytes();
    if (localObject2.length > arrayOfByte.length) {
      localObject1 = localObject2;
    } else {
      localObject1 = arrayOfByte;
    }
    int n = 0;
    while (n < Math.min(localObject2.length, arrayOfByte.length))
    {
      localObject1[n] = ((byte)(localObject2[n] ^ arrayOfByte[n]));
      n += 1;
    }
    if (this.m == null)
    {
      this.m = new Cryptor();
      this.m.enableResultRandom(false);
    }
    return localObject1;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = HexUtil.bytes2HexStr(this.m.encrypt(paramString.getBytes(), this.g));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "encrypt", paramString);
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = (paramInt1 & this.k);
    this.j = (this.l & paramInt2);
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt & this.e) > 0;
  }
  
  public int b()
  {
    return this.j;
  }
  
  public String b(String paramString)
  {
    try
    {
      paramString = HexUtil.hexStr2Bytes(paramString);
      paramString = new String(this.m.decrypt(paramString, this.g));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decrypt", paramString);
      }
    }
    return null;
  }
  
  public boolean b(int paramInt)
  {
    return ((paramInt & this.j) > 0) && ((this.i & 0x40000000) > 0);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & this.l) > 0) && ((this.k & paramInt2) > 0);
  }
  
  public String c(String paramString)
  {
    try
    {
      paramString = HexUtil.hexStr2Bytes(paramString);
      paramString = new String(this.m.decrypt(paramString, this.h));
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.App", 2, "decryptLastData", paramString);
      }
    }
    return null;
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt & this.l) > 0;
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & this.j) > 0) && ((this.i & paramInt2) > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.entity.ThirdPartyApp
 * JD-Core Version:    0.7.0.1
 */