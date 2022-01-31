package com.tencent.mobileqq.olympic;

import java.io.Serializable;

public class OlympicServlet$ReportRecord
  implements Serializable
{
  public long count;
  public long time_stamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("(");
    localStringBuilder.append("time_stamp=").append(this.time_stamp).append(",");
    localStringBuilder.append("count=").append(this.count);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicServlet.ReportRecord
 * JD-Core Version:    0.7.0.1
 */