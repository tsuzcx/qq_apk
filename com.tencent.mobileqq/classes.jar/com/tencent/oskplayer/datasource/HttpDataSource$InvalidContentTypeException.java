package com.tencent.oskplayer.datasource;

import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidContentTypeException
  extends HttpDataSource.HttpDataSourceException
{
  public final String contentType;
  public final Map<String, List<String>> headerFields;
  
  public HttpDataSource$InvalidContentTypeException(String paramString, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
  {
    super("Invalid content type: " + paramString, paramDataSpec);
    this.contentType = paramString;
    this.headerFields = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.HttpDataSource.InvalidContentTypeException
 * JD-Core Version:    0.7.0.1
 */