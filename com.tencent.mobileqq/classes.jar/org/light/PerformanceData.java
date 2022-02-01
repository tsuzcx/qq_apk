package org.light;

public class PerformanceData
{
  public long aiConsumingTime;
  public long ganConsumingTime;
  public long graphicsMemory;
  public long imageDecodingTime;
  public long physicsEngineConsumingTime;
  public long presentingTime;
  public long renderingTime;
  public long scriptConsumingTime;
  public long threeDRenderingTime;
  
  public PerformanceData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9)
  {
    this.renderingTime = paramLong1;
    this.imageDecodingTime = paramLong2;
    this.presentingTime = paramLong3;
    this.graphicsMemory = paramLong4;
    this.threeDRenderingTime = paramLong5;
    this.aiConsumingTime = paramLong6;
    this.ganConsumingTime = paramLong7;
    this.scriptConsumingTime = paramLong8;
    this.physicsEngineConsumingTime = paramLong9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.PerformanceData
 * JD-Core Version:    0.7.0.1
 */