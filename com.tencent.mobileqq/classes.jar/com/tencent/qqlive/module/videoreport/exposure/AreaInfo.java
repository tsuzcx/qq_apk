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
    return "ExposureInfo {viewArea = " + this.viewArea + ", exposureArea = " + this.exposureArea + ", exposureRate = " + this.exposureRate + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.AreaInfo
 * JD-Core Version:    0.7.0.1
 */