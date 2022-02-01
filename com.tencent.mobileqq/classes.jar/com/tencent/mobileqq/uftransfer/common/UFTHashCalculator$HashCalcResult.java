package com.tencent.mobileqq.uftransfer.common;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;

class UFTHashCalculator$HashCalcResult
  implements UFTHashCalculator.IHashCalcResult
{
  byte[] a;
  byte[] b;
  byte[] c;
  byte[] d;
  int e = 0;
  int f = 0;
  int g = 0;
  long h;
  
  private UFTHashCalculator$HashCalcResult(UFTHashCalculator paramUFTHashCalculator) {}
  
  public long a()
  {
    return this.h;
  }
  
  public byte[] b()
  {
    return this.a;
  }
  
  public byte[] c()
  {
    return this.b;
  }
  
  public byte[] d()
  {
    return this.c;
  }
  
  public byte[] e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public int h()
  {
    return this.g;
  }
  
  @NonNull
  public String toString()
  {
    String str1 = UFTDependFeatureApi.a(this.a);
    String str2 = UFTDependFeatureApi.a(this.b);
    String str3 = UFTDependFeatureApi.a(this.c);
    String str4 = UFTDependFeatureApi.a(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fileSize:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" 10Mmd5:");
    localStringBuilder.append(str1);
    localStringBuilder.append("md5:");
    localStringBuilder.append(str2);
    localStringBuilder.append(" sha1:");
    localStringBuilder.append(str3);
    localStringBuilder.append(" sha3:");
    localStringBuilder.append(str4);
    localStringBuilder.append(" mWith:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mHeight:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" mDuration:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.HashCalcResult
 * JD-Core Version:    0.7.0.1
 */