package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.text.TextUtils;

public class DecodeConfig
{
  public String a;
  public int b = 0;
  public boolean c = false;
  public boolean d;
  public long e = 0L;
  public long f = 0L;
  public int g;
  public boolean h = false;
  
  public DecodeConfig()
  {
    this(null, 0, true, false);
  }
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, 0L, 0L);
  }
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean2;
    this.d = paramBoolean1;
    this.e = paramLong1;
    this.f = paramLong2;
  }
  
  public boolean a(DecodeConfig paramDecodeConfig)
  {
    if (paramDecodeConfig != null)
    {
      boolean bool1 = false;
      if (!TextUtils.equals(this.a, paramDecodeConfig.a))
      {
        this.a = paramDecodeConfig.a;
        bool1 = true;
      }
      int i = this.b;
      int j = paramDecodeConfig.b;
      if (i != j)
      {
        this.b = j;
        bool1 = true;
      }
      boolean bool2 = this.c;
      boolean bool3 = paramDecodeConfig.c;
      if (bool2 != bool3)
      {
        this.c = bool3;
        bool1 = true;
      }
      bool2 = this.d;
      bool3 = paramDecodeConfig.d;
      if (bool2 != bool3)
      {
        this.d = bool3;
        bool1 = true;
      }
      long l1 = this.e;
      long l2 = paramDecodeConfig.e;
      if (l1 != l2)
      {
        this.e = l2;
        bool1 = true;
      }
      l1 = this.f;
      l2 = paramDecodeConfig.f;
      if (l1 != l2)
      {
        this.f = l2;
        bool1 = true;
      }
      i = this.g;
      j = paramDecodeConfig.g;
      if (i != j)
      {
        this.g = j;
        bool1 = true;
      }
      bool2 = this.h;
      bool3 = paramDecodeConfig.h;
      if (bool2 != bool3)
      {
        this.h = bool3;
        bool1 = true;
      }
      return bool1;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inputFilePath=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" speedType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" noSleep=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" repeat=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" startTimeMillSecond=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" endTimeMillSecond=");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */