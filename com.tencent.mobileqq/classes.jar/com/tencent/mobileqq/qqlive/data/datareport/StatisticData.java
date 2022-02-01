package com.tencent.mobileqq.qqlive.data.datareport;

import java.util.ArrayList;

public class StatisticData
{
  public int appCpu;
  public int downLoss;
  public ArrayList<StatisticData.LocalStatisticsData> localArray;
  public long receiveBytes;
  public int rtt;
  public long sendBytes;
  public int systemCpu;
  public int upLoss;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StatisticData{appCpu=");
    localStringBuilder.append(this.appCpu);
    localStringBuilder.append(", systemCpu=");
    localStringBuilder.append(this.systemCpu);
    localStringBuilder.append(", rtt=");
    localStringBuilder.append(this.rtt);
    localStringBuilder.append(", upLoss=");
    localStringBuilder.append(this.upLoss);
    localStringBuilder.append(", downLoss=");
    localStringBuilder.append(this.downLoss);
    localStringBuilder.append(", sendBytes=");
    localStringBuilder.append(this.sendBytes);
    localStringBuilder.append(", receiveBytes=");
    localStringBuilder.append(this.receiveBytes);
    localStringBuilder.append(", localArray=");
    localStringBuilder.append(this.localArray);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.datareport.StatisticData
 * JD-Core Version:    0.7.0.1
 */