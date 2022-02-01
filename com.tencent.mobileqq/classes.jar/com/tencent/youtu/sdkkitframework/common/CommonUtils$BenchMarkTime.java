package com.tencent.youtu.sdkkitframework.common;

class CommonUtils$BenchMarkTime
{
  long avg = 0L;
  long begin;
  long cur = 0L;
  long max = -9223372036854775808L;
  long min = 9223372036854775807L;
  long tick = 0L;
  long total = 0L;
  
  private void update(long paramLong)
  {
    this.tick += 1L;
    this.min = Math.min(paramLong, this.min);
    this.max = Math.max(paramLong, this.max);
    this.total += paramLong;
    this.avg = (this.total / this.tick);
  }
  
  public void begin()
  {
    this.begin = System.currentTimeMillis();
  }
  
  public void end()
  {
    this.cur = (System.currentTimeMillis() - this.begin);
    update(this.cur);
  }
  
  public String getTime()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avg: ");
    localStringBuilder.append(this.avg);
    localStringBuilder.append("ms min: ");
    localStringBuilder.append(this.min);
    localStringBuilder.append("ms max: ");
    localStringBuilder.append(this.max);
    localStringBuilder.append("ms cur: ");
    localStringBuilder.append(this.cur);
    localStringBuilder.append("ms");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.CommonUtils.BenchMarkTime
 * JD-Core Version:    0.7.0.1
 */