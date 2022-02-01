package com.tencent.tissue.v8rt.engine;

public class SpeedUtil$ReportPoint
  implements Comparable<ReportPoint>
{
  String event = "";
  long startTs = 0L;
  
  public int compareTo(ReportPoint paramReportPoint)
  {
    long l = this.startTs - paramReportPoint.startTs;
    if (l < 0L) {
      return -1;
    }
    if (l > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.SpeedUtil.ReportPoint
 * JD-Core Version:    0.7.0.1
 */