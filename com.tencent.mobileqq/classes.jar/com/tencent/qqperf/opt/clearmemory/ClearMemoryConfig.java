package com.tencent.qqperf.opt.clearmemory;

import android.util.SparseArray;

public class ClearMemoryConfig
{
  public String a;
  public boolean b = true;
  public int c;
  public int d = 4;
  public SparseArray<ClearMemoryConfig.MemoryLevelInfo> e = new SparseArray(3);
  
  public ClearMemoryConfig(String paramString)
  {
    this.a = paramString;
  }
  
  public ClearMemoryConfig.MemoryLevelInfo a(int paramInt)
  {
    ClearMemoryConfig.MemoryLevelInfo localMemoryLevelInfo2 = (ClearMemoryConfig.MemoryLevelInfo)this.e.get(paramInt);
    ClearMemoryConfig.MemoryLevelInfo localMemoryLevelInfo1 = localMemoryLevelInfo2;
    if (localMemoryLevelInfo2 == null)
    {
      if (paramInt == 1) {
        return new ClearMemoryConfig.MemoryLevelInfo(85, 5, 0.7F, 0.2F);
      }
      if (paramInt == 2) {
        return new ClearMemoryConfig.MemoryLevelInfo(80, 15, 0.9F, 0.4F);
      }
      localMemoryLevelInfo1 = localMemoryLevelInfo2;
      if (paramInt == 3) {
        localMemoryLevelInfo1 = new ClearMemoryConfig.MemoryLevelInfo(75, 30, 1.0F, 0.7F);
      }
    }
    return localMemoryLevelInfo1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ClearMemoryConfig{");
    localStringBuilder.append("DpcConfigId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isClearEnable=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", delay=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", clearStep=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", clearLevels=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.ClearMemoryConfig
 * JD-Core Version:    0.7.0.1
 */