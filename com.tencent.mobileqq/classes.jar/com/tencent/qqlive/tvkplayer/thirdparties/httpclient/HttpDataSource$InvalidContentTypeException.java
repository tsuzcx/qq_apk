package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

public final class HttpDataSource$InvalidContentTypeException
  extends HttpDataSource.HttpDataSourceException
{
  public final String contentType;
  
  public HttpDataSource$InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
  {
    super(localStringBuilder.toString(), paramDataSpec, 1);
    this.contentType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.InvalidContentTypeException
 * JD-Core Version:    0.7.0.1
 */