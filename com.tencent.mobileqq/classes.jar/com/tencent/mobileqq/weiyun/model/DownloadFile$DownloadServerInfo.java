package com.tencent.mobileqq.weiyun.model;

public class DownloadFile$DownloadServerInfo
  implements Cloneable
{
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  private DownloadFile$DownloadServerInfo(DownloadFile paramDownloadFile, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public DownloadServerInfo a()
  {
    try
    {
      DownloadServerInfo localDownloadServerInfo = (DownloadServerInfo)super.clone();
      return localDownloadServerInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.model.DownloadFile.DownloadServerInfo
 * JD-Core Version:    0.7.0.1
 */