package com.tencent.mobileqq.statistics;

import java.text.SimpleDateFormat;

final class FDStats$1
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStats.1
 * JD-Core Version:    0.7.0.1
 */