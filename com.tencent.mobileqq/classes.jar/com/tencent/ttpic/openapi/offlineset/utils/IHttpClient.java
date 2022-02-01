package com.tencent.ttpic.openapi.offlineset.utils;

public abstract interface IHttpClient
{
  public abstract void download(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void get(int paramInt, String paramString1, String paramString2);
  
  public abstract void post(int paramInt, String paramString1, String paramString2);
  
  public abstract void setResponseListener(IResponseListener paramIResponseListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.utils.IHttpClient
 * JD-Core Version:    0.7.0.1
 */