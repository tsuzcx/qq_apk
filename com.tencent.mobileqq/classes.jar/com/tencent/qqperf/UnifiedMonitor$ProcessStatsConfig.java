package com.tencent.qqperf;

class UnifiedMonitor$ProcessStatsConfig
  extends UnifiedMonitor.FamilyConfig
{
  long c = 0L;
  boolean e = false;
  int j = 80;
  int k = 70;
  int l = 5;
  int m;
  
  UnifiedMonitor$ProcessStatsConfig(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramInt4, paramInt5, paramInt6, false);
    this.l = (paramInt1 % 1000);
    this.k = (paramInt1 / 1000 % 1000);
    this.j = (paramInt1 / 1000 / 1000 % 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor.ProcessStatsConfig
 * JD-Core Version:    0.7.0.1
 */