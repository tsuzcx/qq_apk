package com.tencent.mobileqq.utils.httputils;

public abstract interface IHttpCommunicatorListener
{
  public abstract void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2);
  
  public abstract void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2);
  
  public abstract void handleRedirect(String paramString);
  
  public abstract boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
 * JD-Core Version:    0.7.0.1
 */