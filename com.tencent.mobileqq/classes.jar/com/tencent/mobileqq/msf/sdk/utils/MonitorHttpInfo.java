package com.tencent.mobileqq.msf.sdk.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MonitorHttpInfo
  implements Serializable
{
  public static final int APK = 1;
  public static final int GUESSED_APK = 2;
  public static final int UNKNOW = -1;
  private int fileType = -1;
  private String host = "";
  private String method = "";
  private String mimeType = "";
  private String port = "";
  private byte[] requestBuffer = new byte[0];
  private String responseBodyHex = "";
  private String responseCode = "";
  ArrayList responseHeaderGuessInfo = new ArrayList();
  private String responseLength = "";
  private String type = "";
  private String url = "";
  
  public int getFileType()
  {
    return this.fileType;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public String getPort()
  {
    return this.port;
  }
  
  public byte[] getRequestBuffer()
  {
    return this.requestBuffer;
  }
  
  public String getResponseBodyHex()
  {
    return this.responseBodyHex;
  }
  
  public String getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getResponseLength()
  {
    return this.responseLength;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setFileType(int paramInt)
  {
    this.fileType = paramInt;
  }
  
  public void setHost(String paramString)
  {
    this.host = paramString;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setMimeType(String paramString)
  {
    this.mimeType = paramString;
  }
  
  public void setPort(String paramString)
  {
    this.port = paramString;
  }
  
  public void setRequestBuffer(byte[] paramArrayOfByte)
  {
    this.requestBuffer = paramArrayOfByte;
  }
  
  public void setResponseBodyHex(String paramString)
  {
    this.responseBodyHex = paramString;
  }
  
  public void setResponseCode(String paramString)
  {
    this.responseCode = paramString;
  }
  
  public void setResponseLength(String paramString)
  {
    this.responseLength = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return "MonitorHttpInfo{host='" + this.host + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", port='" + this.port + '\'' + ", type='" + this.type + '\'' + ", requestBuffer=" + Arrays.toString(this.requestBuffer).substring(0, 100) + ", responseCode='" + this.responseCode + '\'' + ", mimeType='" + this.mimeType + '\'' + ", responseLength='" + this.responseLength + '\'' + ", responseHeaderGuessInfo=" + this.responseHeaderGuessInfo + ", responseBodyHex='" + this.responseBodyHex + '\'' + ", fileType=" + this.fileType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo
 * JD-Core Version:    0.7.0.1
 */