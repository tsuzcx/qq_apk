package com.tencent.mobileqq.qqlive.data;

public class QQLiveAudienceDtReportData
{
  public int gameId;
  public int roomType;
  public String source;
  public String traceInfo;
  public long videoSource;
  
  public QQLiveAudienceDtReportData(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2)
  {
    this.roomType = paramInt1;
    this.videoSource = paramLong;
    this.gameId = paramInt2;
    this.source = paramString1;
    this.traceInfo = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.QQLiveAudienceDtReportData
 * JD-Core Version:    0.7.0.1
 */