package com.tencent.qqperf.opt.clearmemory;

public class ClearMemoryConfig$MemoryLevelInfo
{
  public int a;
  public int b;
  public float c;
  public float d;
  
  public ClearMemoryConfig$MemoryLevelInfo(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MemoryLevelInfo{");
    localStringBuilder.append("MemoryPercent=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", delayTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", maxCacheSize=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", trimPercent=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.ClearMemoryConfig.MemoryLevelInfo
 * JD-Core Version:    0.7.0.1
 */