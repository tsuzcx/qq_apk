package com.tencent.mobileqq.transfile;

public class AbstractImageDownloader$ReportData
{
  boolean clientExist;
  int fileId;
  long fileSize;
  String logTag;
  String md5;
  String msgDate;
  long msgTime;
  String multiMediaEvtTag;
  String peerUin;
  String srvAddr;
  String srvUrl;
  String uuid;
  
  public AbstractImageDownloader$ReportData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.peerUin = paramString1;
    this.logTag = paramString2;
    this.multiMediaEvtTag = paramString3;
    this.srvAddr = paramString4;
    this.srvUrl = paramString5;
    this.uuid = paramString6;
  }
  
  public AbstractImageDownloader$ReportData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7)
  {
    this.peerUin = paramString1;
    this.logTag = paramString2;
    this.multiMediaEvtTag = paramString3;
    this.srvAddr = paramString4;
    this.srvUrl = paramString5;
    this.uuid = paramString6;
    this.fileSize = paramLong;
    this.md5 = paramString7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader.ReportData
 * JD-Core Version:    0.7.0.1
 */