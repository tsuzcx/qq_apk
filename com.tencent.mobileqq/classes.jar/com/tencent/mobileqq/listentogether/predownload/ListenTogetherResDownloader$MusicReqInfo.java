package com.tencent.mobileqq.listentogether.predownload;

import com.tencent.open.base.MD5Utils;

class ListenTogetherResDownloader$MusicReqInfo
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  
  public ListenTogetherResDownloader$MusicReqInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = MD5Utils.toMD5(paramString2);
    this.e = ListenTogetherResDownloader.b(paramString1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicReqInfo{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", cachePath='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.MusicReqInfo
 * JD-Core Version:    0.7.0.1
 */