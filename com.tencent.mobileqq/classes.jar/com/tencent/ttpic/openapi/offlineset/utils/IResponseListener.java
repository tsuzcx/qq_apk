package com.tencent.ttpic.openapi.offlineset.utils;

public abstract interface IResponseListener
{
  public static final int STATUS_ERR = 1;
  public static final int STATUS_OK = 0;
  
  public abstract void response(int paramInt1, int paramInt2, String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.utils.IResponseListener
 * JD-Core Version:    0.7.0.1
 */