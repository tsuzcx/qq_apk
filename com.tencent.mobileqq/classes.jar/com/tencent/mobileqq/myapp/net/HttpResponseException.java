package com.tencent.mobileqq.myapp.net;

public class HttpResponseException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private int stateCode = 200;
  
  public HttpResponseException(int paramInt)
  {
    this.stateCode = paramInt;
  }
  
  public int getStateCode()
  {
    return this.stateCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.myapp.net.HttpResponseException
 * JD-Core Version:    0.7.0.1
 */