package com.tencent.mobileqq.transfile;

public class ChatPicDownloadFailedException
  extends RuntimeException
{
  int errorCode;
  long errorDetailCode;
  boolean needReport = true;
  private boolean needRetry = false;
  
  public ChatPicDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString);
    this.errorCode = paramInt;
    this.errorDetailCode = paramLong;
    this.needRetry = paramBoolean1;
    this.needReport = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatPicDownloadFailedException
 * JD-Core Version:    0.7.0.1
 */