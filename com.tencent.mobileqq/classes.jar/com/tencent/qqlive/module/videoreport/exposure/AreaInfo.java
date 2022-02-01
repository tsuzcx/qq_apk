package com.tencent.qqlive.module.videoreport.exposure;

public class AreaInfo
{
  public final long exposureArea;
  public final double exposureRate;
  public final long viewArea;
  
  public AreaInfo(long paramLong1, long paramLong2, double paramDouble)
  {
    this.viewArea = paramLong1;
    this.exposureArea = paramLong2;
    this.exposureRate = paramDouble;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExposureInfo {viewArea = ");
    localStringBuilder.append(this.viewArea);
    localStringBuilder.append(", exposureArea = ");
    localStringBuilder.append(this.exposureArea);
    localStringBuilder.append(", exposureRate = ");
    localStringBuilder.append(this.exposureRate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.AreaInfo
 * JD-Core Version:    0.7.0.1
 */