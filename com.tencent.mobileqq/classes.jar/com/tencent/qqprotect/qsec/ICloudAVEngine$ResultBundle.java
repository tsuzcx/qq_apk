package com.tencent.qqprotect.qsec;

public class ICloudAVEngine$ResultBundle
{
  public int a;
  public int b;
  public int c;
  public long d;
  public int e;
  public boolean f;
  public byte[] g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",cate:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",subcate:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",expire:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",act:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",iscache:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle
 * JD-Core Version:    0.7.0.1
 */