package com.tencent.qqmusic.mediaplayer.upstream;

public class DataSourceException
  extends Exception
{
  private final int errorCode;
  
  public DataSourceException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataSourceException{errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append("\nmessage=");
    localStringBuilder.append(getMessage());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DataSourceException
 * JD-Core Version:    0.7.0.1
 */