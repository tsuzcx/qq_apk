package com.tencent.tencentmap.net;

import com.tencent.map.sdk.a.qk;

public class NetResponse
{
  public String charset = "GBK";
  public byte[] data;
  public int errorCode = -1;
  public byte[] errorData;
  public Exception exception;
  public int statusCode;
  
  public NetResponse() {}
  
  public NetResponse(com.tencent.map.tools.net.NetResponse paramNetResponse)
  {
    if (paramNetResponse != null)
    {
      this.errorCode = paramNetResponse.errorCode;
      this.statusCode = paramNetResponse.statusCode;
      this.data = paramNetResponse.data;
      this.charset = paramNetResponse.charset;
      this.exception = paramNetResponse.exception;
      this.errorData = paramNetResponse.errorData;
    }
  }
  
  public NetResponse(Exception paramException)
  {
    this.exception = paramException;
    if ((paramException instanceof qk))
    {
      paramException = (qk)paramException;
      this.errorCode = paramException.errorCode;
      this.statusCode = paramException.statusCode;
    }
  }
  
  public boolean available()
  {
    byte[] arrayOfByte;
    if ((this.errorCode != 0) || (this.statusCode != 200)) {
      arrayOfByte = this.data;
    }
    return (arrayOfByte != null) && (arrayOfByte.length > 0);
  }
  
  public String toString()
  {
    try
    {
      if (this.data != null)
      {
        String str = new String(this.data, this.charset);
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.net.NetResponse
 * JD-Core Version:    0.7.0.1
 */