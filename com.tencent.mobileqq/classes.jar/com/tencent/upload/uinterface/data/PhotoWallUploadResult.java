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
    return "url=" + this.url + ",ctime=" + this.ctime + ",filekey=" + this.filekey + ",publish_code=" + this.publish_code + ",burl=" + this.burl + ",murl=" + this.murl + ",surl=" + this.surl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.PhotoWallUploadResult
 * JD-Core Version:    0.7.0.1
 */