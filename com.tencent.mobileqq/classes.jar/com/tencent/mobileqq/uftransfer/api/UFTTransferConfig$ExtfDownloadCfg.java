package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$ExtfDownloadCfg
{
  public long a = 524288L;
  public int b = 3;
  public int c = 30;
  public int d = 1000;
  public int e = 2000;
  public int f = 10;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtfDownloadCfg{sliceSize=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", maxParrallelSlice=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", maxWaitingSlice=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", notifyIntervals=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", speedDuration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", sliceNum=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfDownloadCfg
 * JD-Core Version:    0.7.0.1
 */