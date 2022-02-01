package com.tencent.thumbplayer.core.drm.httpclient;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.HttpDataSource.InvalidContentTypeException
 * JD-Core Version:    0.7.0.1
 */