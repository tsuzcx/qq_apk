package com.tencent.qqperf;

class UnifiedMonitor$ProcessStatsConfig
  extends UnifiedMonitor.FamilyConfig
{
  boolean u = false;
  int v = 80;
  int w = 70;
  int x = 5;
  int y;
  long z = 0L;
  
  UnifiedMonitor$ProcessStatsConfig(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramInt4, paramInt5, paramInt6, false);
    this.x = (paramInt1 % 1000);
    paramInt1 /= 1000;
    this.w = (paramInt1 % 1000);
    this.v = (paramInt1 / 1000 % 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor.ProcessStatsConfig
 * JD-Core Version:    0.7.0.1
 */