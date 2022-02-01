package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException
  extends HttpDataSource.HttpDataSourceException
{
  public final Map<String, List<String>> headerFields;
  public final int responseCode;
  @Nullable
  public final String responseMessage;
  
  public HttpDataSource$InvalidResponseCodeException(int paramInt, @Nullable String paramString, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
  {
    super("Response code: " + paramInt, paramDataSpec, 1);
    this.responseCode = paramInt;
    this.responseMessage = paramString;
    this.headerFields = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.InvalidResponseCodeException
 * JD-Core Version:    0.7.0.1
 */