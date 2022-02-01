package com.tencent.mobileqq.uftransfer.api;

public class UFTTroopFileUploadBusinessInfo
  extends UFTFileUploadBusinessInfo
{
  private int a;
  private String b;
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public int h()
  {
    return this.a;
  }
  
  public String i()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UFTTroopFileUploadBusiInfo{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", busId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", serverDns='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTroopFileUploadBusinessInfo
 * JD-Core Version:    0.7.0.1
 */