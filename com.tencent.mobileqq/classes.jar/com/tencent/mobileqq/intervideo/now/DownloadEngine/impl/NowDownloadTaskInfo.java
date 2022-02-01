package com.tencent.mobileqq.intervideo.now.DownloadEngine.impl;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

public class NowDownloadTaskInfo
{
  public String a;
  public String b;
  public String c;
  public String d = "now_for_qq";
  public String e = "now_appid_2";
  public String f = "now";
  public int g = 0;
  public String h;
  public String i;
  public long j;
  private DownloaderTask k;
  
  public static NowDownloadTaskInfo a(String paramString1, String paramString2, String paramString3)
  {
    NowDownloadTaskInfo localNowDownloadTaskInfo = new NowDownloadTaskInfo();
    localNowDownloadTaskInfo.a = "2";
    localNowDownloadTaskInfo.h = paramString3.substring(0, paramString3.lastIndexOf("/") + 1);
    localNowDownloadTaskInfo.i = paramString3.substring(paramString3.lastIndexOf("/") + 1);
    localNowDownloadTaskInfo.b = paramString1;
    localNowDownloadTaskInfo.c = paramString2;
    localNowDownloadTaskInfo.j = System.currentTimeMillis();
    QLog.i("NowDownloadTaskInfo", 4, localNowDownloadTaskInfo.toString());
    return localNowDownloadTaskInfo;
  }
  
  public DownloaderTask a()
  {
    return this.k;
  }
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    this.k = paramDownloaderTask;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", url = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", downloadDir = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", fileName = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", taskSource = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", appName = ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.DownloadEngine.impl.NowDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */