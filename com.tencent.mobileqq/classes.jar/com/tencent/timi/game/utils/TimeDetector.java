package com.tencent.timi.game.utils;

import java.util.Locale;

public class TimeDetector
{
  private long a;
  private long b;
  private long c;
  
  public static TimeDetector a()
  {
    return new TimeDetector();
  }
  
  public void a(String paramString)
  {
    long l1 = System.nanoTime();
    long l2 = l1 - this.b;
    this.c += l2;
    this.b = l1;
    if (this.a == 0L)
    {
      Logger.c("TimeDetector_", "you need call begin() first!!");
      return;
    }
    Logger.a("TimeDetector_", String.format(Locale.CHINA, "%s Consume(%dms),TotalConsume(%dms)", new Object[] { paramString, Long.valueOf(l2 / 1000000L), Long.valueOf(this.c / 1000000L) }));
  }
  
  public void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    a(localStringBuilder.toString());
  }
  
  public TimeDetector b()
  {
    this.a = System.nanoTime();
    this.b = this.a;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.TimeDetector
 * JD-Core Version:    0.7.0.1
 */