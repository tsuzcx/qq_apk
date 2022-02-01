package com.tencent.mobileqq.transfile.predownload.schedule;

import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;

public class PreDownloadItem
{
  public String businessEngName;
  public int businessID;
  public String businessName;
  public int businessPriority = 0;
  public String department;
  public String downNetWork;
  public long downloadSize = 0L;
  public long downloadTime = 0L;
  public String downloadUrl;
  public String fileKey;
  public String filePath;
  public int innerPriority = 0;
  public int reqCondition = 0;
  public int reqNetWork = 0;
  public long reqTime = 0L;
  public boolean saveOnSD;
  public int startCondition = 0;
  public long startTime = 0L;
  public int state = 0;
  public AbsPreDownloadTask task;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadItem
 * JD-Core Version:    0.7.0.1
 */