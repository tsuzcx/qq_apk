package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

public class NowDownloadTaskInfo
{
  public int a;
  public long a;
  private DownloaderTask a;
  public String a;
  public String b;
  public String c;
  public String d = "now_for_qq";
  public String e = "now_appid_2";
  public String f = "now";
  public String g;
  public String h;
  
  public NowDownloadTaskInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static NowDownloadTaskInfo a(String paramString1, String paramString2, String paramString3)
  {
    NowDownloadTaskInfo localNowDownloadTaskInfo = new NowDownloadTaskInfo();
    localNowDownloadTaskInfo.jdField_a_of_type_JavaLangString = "2";
    localNowDownloadTaskInfo.g = paramString3.substring(0, paramString3.lastIndexOf("/") + 1);
    localNowDownloadTaskInfo.h = paramString3.substring(paramString3.lastIndexOf("/") + 1);
    localNowDownloadTaskInfo.b = paramString1;
    localNowDownloadTaskInfo.c = paramString2;
    localNowDownloadTaskInfo.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i("NowDownloadTaskInfo", 4, localNowDownloadTaskInfo.toString());
    return localNowDownloadTaskInfo;
  }
  
  public DownloaderTask a()
  {
    return this.jdField_a_of_type_ComTencentHlyybDownloaderDownloaderTask;
  }
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloaderTask = paramDownloaderTask;
  }
  
  public String toString()
  {
    return "appid = " + this.jdField_a_of_type_JavaLangString + ", url = " + this.b + ", downloadDir = " + this.g + ", fileName = " + this.h + ", taskSource = " + this.e + ", appName = " + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */