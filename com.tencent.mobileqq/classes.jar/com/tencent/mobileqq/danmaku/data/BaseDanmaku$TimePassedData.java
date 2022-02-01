package com.tencent.mobileqq.danmaku.data;

public final class BaseDanmaku$TimePassedData
  implements Comparable<TimePassedData>
{
  public long a;
  public final BaseDanmaku.ITimePassedListener a;
  
  public int a(TimePassedData paramTimePassedData)
  {
    if (paramTimePassedData == null) {}
    do
    {
      return 1;
      if (this.a > paramTimePassedData.a) {
        return -1;
      }
    } while (this.a < paramTimePassedData.a);
    return 0;
  }
  
  public String toString()
  {
    return "mRemainTime:" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.data.BaseDanmaku.TimePassedData
 * JD-Core Version:    0.7.0.1
 */