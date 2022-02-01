package com.vivo.push.util;

public class VivoPushException
  extends Exception
{
  public static final int REASON_CODE_ACCESS = 10000;
  private int mReasonCode;
  
  public VivoPushException(int paramInt, String paramString)
  {
    super(paramString);
    this.mReasonCode = paramInt;
  }
  
  public VivoPushException(String paramString)
  {
    this(10000, paramString);
  }
  
  public int getCode()
  {
    return this.mReasonCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.VivoPushException
 * JD-Core Version:    0.7.0.1
 */