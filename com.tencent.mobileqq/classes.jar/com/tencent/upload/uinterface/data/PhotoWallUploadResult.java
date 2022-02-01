package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.AbstractUploadResult;

public class PhotoWallUploadResult
  extends AbstractUploadResult
{
  public String burl = "";
  public int ctime;
  public String filekey = "";
  public String murl = "";
  public int publish_code = 0;
  public String stackMsg = "";
  public String surl = "";
  public String url = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(",ctime=");
    localStringBuilder.append(this.ctime);
    localStringBuilder.append(",filekey=");
    localStringBuilder.append(this.filekey);
    localStringBuilder.append(",publish_code=");
    localStringBuilder.append(this.publish_code);
    localStringBuilder.append(",burl=");
    localStringBuilder.append(this.burl);
    localStringBuilder.append(",murl=");
    localStringBuilder.append(this.murl);
    localStringBuilder.append(",surl=");
    localStringBuilder.append(this.surl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.PhotoWallUploadResult
 * JD-Core Version:    0.7.0.1
 */