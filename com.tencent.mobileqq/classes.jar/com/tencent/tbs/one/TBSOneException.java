package com.tencent.tbs.one;

public class TBSOneException
  extends Exception
{
  private int mErrorCode = -1;
  
  public TBSOneException(int paramInt, String paramString)
  {
    super(paramString);
    this.mErrorCode = paramInt;
  }
  
  public TBSOneException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.mErrorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.mErrorCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneException
 * JD-Core Version:    0.7.0.1
 */