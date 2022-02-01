package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.text.TextUtils;
import org.jetbrains.annotations.NotNull;

public class DecodeConfig
{
  public String a;
  public long b = 0L;
  public long c = 0L;
  int d;
  boolean e;
  boolean f;
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.d = paramInt;
    this.e = paramBoolean2;
    this.f = paramBoolean1;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  void a(DecodeConfig paramDecodeConfig)
  {
    if (paramDecodeConfig != null)
    {
      if (!TextUtils.equals(this.a, paramDecodeConfig.a)) {
        this.a = paramDecodeConfig.a;
      }
      int i = this.d;
      int j = paramDecodeConfig.d;
      if (i != j) {
        this.d = j;
      }
      boolean bool1 = this.e;
      boolean bool2 = paramDecodeConfig.e;
      if (bool1 != bool2) {
        this.e = bool2;
      }
      bool1 = this.f;
      bool2 = paramDecodeConfig.f;
      if (bool1 != bool2) {
        this.f = bool2;
      }
      long l1 = this.b;
      long l2 = paramDecodeConfig.b;
      if (l1 != l2) {
        this.b = l2;
      }
      l1 = this.c;
      l2 = paramDecodeConfig.c;
      if (l1 != l2) {
        this.c = l2;
      }
      return;
    }
    throw new NullPointerException();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inputFilePath=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" speedType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" noSleep=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" repeat=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" startTimeMillSecond=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" endTimeMillSecond=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */