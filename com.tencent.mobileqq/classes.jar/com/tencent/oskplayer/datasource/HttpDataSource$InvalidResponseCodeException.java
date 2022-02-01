package com.tencent.oskplayer.datasource;

import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException
  extends HttpDataSource.HttpDataSourceException
{
  public final Map<String, List<String>> headerFields;
  public final int responseCode;
  
  public HttpDataSource$InvalidResponseCodeException(int paramInt, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
  {
    super("Response code: " + paramInt, paramDataSpec);
    this.responseCode = paramInt;
    this.headerFields = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.HttpDataSource.InvalidResponseCodeException
 * JD-Core Version:    0.7.0.1
 */