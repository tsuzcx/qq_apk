package com.tencent.mobileqq.uftransfer.api;

public class UFTTransferConfig$ExtfDownloadCfg
{
  public int a;
  public long a;
  public int b = 30;
  public int c = 1000;
  public int d = 2000;
  public int e = 10;
  
  public UFTTransferConfig$ExtfDownloadCfg()
  {
    this.jdField_a_of_type_Long = 524288L;
    this.jdField_a_of_type_Int = 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtfDownloadCfg{sliceSize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", maxParrallelSlice=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", maxWaitingSlice=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", notifyIntervals=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", speedDuration=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", sliceNum=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfDownloadCfg
 * JD-Core Version:    0.7.0.1
 */