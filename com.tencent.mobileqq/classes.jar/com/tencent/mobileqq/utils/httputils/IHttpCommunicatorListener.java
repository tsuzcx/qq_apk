package com.tencent.mobileqq.utils.httputils;

public abstract interface IHttpCommunicatorListener
{
  public abstract void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt);
  
  public abstract void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
 * JD-Core Version:    0.7.0.1
 */