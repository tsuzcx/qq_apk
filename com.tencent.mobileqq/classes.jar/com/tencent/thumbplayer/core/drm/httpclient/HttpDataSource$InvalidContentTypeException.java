package com.tencent.thumbplayer.core.drm.httpclient;

public final class HttpDataSource$InvalidContentTypeException
  extends HttpDataSource.HttpDataSourceException
{
  public final String contentType;
  
  public HttpDataSource$InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
  {
    super("Invalid content type: " + paramString, paramDataSpec, 1);
    this.contentType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.HttpDataSource.InvalidContentTypeException
 * JD-Core Version:    0.7.0.1
 */