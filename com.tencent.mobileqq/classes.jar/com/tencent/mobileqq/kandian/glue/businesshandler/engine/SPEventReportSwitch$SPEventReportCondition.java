package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class SPEventReportSwitch$SPEventReportCondition
  implements Serializable
{
  private boolean needReportNextTime;
  private ArrayList<TreeSet<Integer>> timeSeq;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SPEventReportCondition{needReportNextTime=");
    localStringBuilder.append(this.needReportNextTime);
    localStringBuilder.append(", timeSeq=");
    localStringBuilder.append(this.timeSeq);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.SPEventReportSwitch.SPEventReportCondition
 * JD-Core Version:    0.7.0.1
 */