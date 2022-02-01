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
    localStringBuilder.append("filename:").append(this.filename).append("\n");
    localStringBuilder.append("version:").append(this.version).append("\n");
    localStringBuilder.append("URL:").append(this.URL).append("\n");
    localStringBuilder.append("MD5:").append(this.MD5).append("\n");
    localStringBuilder.append("JARMD5:").append(this.JARMD5).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.SDKLocalConfig
 * JD-Core Version:    0.7.0.1
 */