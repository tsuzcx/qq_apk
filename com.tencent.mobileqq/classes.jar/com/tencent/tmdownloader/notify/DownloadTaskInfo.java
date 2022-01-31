package com.tencent.tmdownloader.notify;

public class DownloadTaskInfo
{
  public String pkgName;
  public String source;
  public String stackInfo;
  public String url;
  public int versionCode;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.versionCode).append("||").append(this.source).append("||").append(this.pkgName).append("||").append(this.url).append("||");
    if (this.stackInfo == null) {}
    for (String str = "";; str = this.stackInfo.replace("\r", " ").replace("\n", " ")) {
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.notify.DownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */