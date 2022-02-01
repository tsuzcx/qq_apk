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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append("||");
    localStringBuilder.append(this.source);
    localStringBuilder.append("||");
    localStringBuilder.append(this.pkgName);
    localStringBuilder.append("||");
    localStringBuilder.append(this.url);
    localStringBuilder.append("||");
    String str = this.stackInfo;
    if (str == null) {
      str = "";
    } else {
      str = str.replace("\r", " ").replace("\n", " ");
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.notify.DownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */