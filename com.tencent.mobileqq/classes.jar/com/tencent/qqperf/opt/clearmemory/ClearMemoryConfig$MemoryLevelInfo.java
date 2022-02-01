package com.tencent.qqperf.opt.clearmemory;

public class ClearMemoryConfig$MemoryLevelInfo
{
  public float a;
  public int a;
  public float b;
  public int b;
  
  public ClearMemoryConfig$MemoryLevelInfo(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MemoryLevelInfo{");
    localStringBuilder.append("MemoryPercent=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", delayTime=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", maxCacheSize=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", trimPercent=");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.ClearMemoryConfig.MemoryLevelInfo
 * JD-Core Version:    0.7.0.1
 */