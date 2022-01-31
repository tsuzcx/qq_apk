package com.tencent.qqmini.sdk.core.proxy.service;

public class DownloadException
  extends RuntimeException
{
  private int code;
  
  public DownloadException(int paramInt, String paramString)
  {
    super(paramString);
    this.code = paramInt;
  }
  
  public int getCode()
  {
    return this.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloadException
 * JD-Core Version:    0.7.0.1
 */