package com.tencent.mobileqq.utils.confighandler;

public class QAVFunCallConfig$FCItem
{
  long begin = 0L;
  int downloadStatus = 0;
  long end = 0L;
  int fcid = 0;
  String media = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fcid[");
    localStringBuilder.append(this.fcid);
    localStringBuilder.append("], begin[");
    localStringBuilder.append(this.begin);
    localStringBuilder.append("], end[");
    localStringBuilder.append(this.end);
    localStringBuilder.append("], media[");
    localStringBuilder.append(this.media);
    localStringBuilder.append("], edownloadStatusnd[");
    localStringBuilder.append(this.downloadStatus);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig.FCItem
 * JD-Core Version:    0.7.0.1
 */