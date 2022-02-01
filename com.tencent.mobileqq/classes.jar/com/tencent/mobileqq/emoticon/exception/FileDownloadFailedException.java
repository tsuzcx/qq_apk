package com.tencent.mobileqq.emoticon.exception;

public class FileDownloadFailedException
  extends RuntimeException
{
  int errorCode;
  long errorDetailCode;
  boolean needReport = true;
  private boolean needRetry = false;
  
  public FileDownloadFailedException(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt1;
    this.errorDetailCode = paramInt2;
    this.needRetry = paramBoolean;
  }
  
  public FileDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    this(paramInt, paramLong, paramString, paramBoolean, true);
  }
  
  public FileDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString);
    this.errorCode = paramInt;
    this.errorDetailCode = paramLong;
    this.needRetry = paramBoolean1;
    this.needReport = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException
 * JD-Core Version:    0.7.0.1
 */