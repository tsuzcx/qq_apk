package com.tencent.qqlive.mediaplayer.sdkupdate;

import java.io.Serializable;

public class SDKLocalConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String JARMD5 = null;
  public String MD5 = null;
  public String URL = null;
  public String filename = null;
  public String version = null;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" SDKLocalConfig[");
    localStringBuilder.append("filename:");
    localStringBuilder.append(this.filename);
    localStringBuilder.append("\n");
    localStringBuilder.append("version:");
    localStringBuilder.append(this.version);
    localStringBuilder.append("\n");
    localStringBuilder.append("URL:");
    localStringBuilder.append(this.URL);
    localStringBuilder.append("\n");
    localStringBuilder.append("MD5:");
    localStringBuilder.append(this.MD5);
    localStringBuilder.append("\n");
    localStringBuilder.append("JARMD5:");
    localStringBuilder.append(this.JARMD5);
    localStringBuilder.append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.SDKLocalConfig
 * JD-Core Version:    0.7.0.1
 */