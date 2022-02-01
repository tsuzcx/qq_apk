package com.tencent.qqlive.tvkplayer.tools.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.BasicNetwork;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.DefaultHttpDataSourceFactory;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.Factory;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource.InvalidResponseCodeException;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Request;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.RequestQueue;
import com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Response;
import java.util.Map;

public class TVKHttpClient
  implements ITVKHttpProcessor
{
  private static volatile TVKHttpClient mHttpClient;
  private final HttpDataSource.Factory mHttpSrcFactory;
  private final RequestQueue mRequestQueue;
  
  private TVKHttpClient(HttpDataSource.Factory paramFactory)
  {
    if (paramFactory == null) {}
    for (this.mHttpSrcFactory = new DefaultHttpDataSourceFactory("qqlive");; this.mHttpSrcFactory = paramFactory)
    {
      this.mRequestQueue = new RequestQueue(new BasicNetwork(this.mHttpSrcFactory), 2);
      this.mRequestQueue.start();
      return;
    }
  }
  
  public static TVKHttpClient getInstance()
  {
    return initHttpClient(null);
  }
  
  private void httpMethodAsync(int paramInt1, String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt2, ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    paramString = new Request(paramInt1, paramString, paramMap, paramArrayOfByte, paramInt2, new TVKHttpClient.1(this, paramITVKHttpCallback));
    this.mRequestQueue.add(paramString);
  }
  
  private ITVKHttpProcessor.HttpResponse httpMethodSync(int paramInt1, String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt2)
  {
    paramString = new Request(paramInt1, paramString, paramMap, paramArrayOfByte, paramInt2, null);
    try
    {
      paramString = new BasicNetwork(this.mHttpSrcFactory).performRequest(paramString);
      paramString = new ITVKHttpProcessor.HttpResponse(paramString.responseHeaders, paramString.result);
      return paramString;
    }
    catch (HttpDataSource.InvalidResponseCodeException paramString)
    {
      throw new ITVKHttpProcessor.InvalidResponseCodeException(paramString.responseCode, paramString.responseMessage);
    }
  }
  
  private void httpMethodSync(int paramInt1, String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt2, ITVKHttpProcessor.IWriteCallback paramIWriteCallback)
  {
    paramString = new Request(paramInt1, paramString, paramMap, paramArrayOfByte, paramInt2, null);
    try
    {
      new BasicNetwork(this.mHttpSrcFactory).performRequest(paramString, new TVKHttpClient.2(this, paramIWriteCallback));
      return;
    }
    catch (HttpDataSource.InvalidResponseCodeException paramString)
    {
      throw new ITVKHttpProcessor.InvalidResponseCodeException(paramString.responseCode, paramString.responseMessage);
    }
  }
  
  public static TVKHttpClient initHttpClient(HttpDataSource.Factory paramFactory)
  {
    if (mHttpClient == null) {}
    try
    {
      if (mHttpClient == null) {
        mHttpClient = new TVKHttpClient(paramFactory);
      }
      return mHttpClient;
    }
    finally {}
  }
  
  public void deleteAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    httpMethodAsync(5, paramString, paramMap, null, paramInt, paramITVKHttpCallback);
  }
  
  public ITVKHttpProcessor.HttpResponse deleteSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt)
  {
    return httpMethodSync(5, paramString, paramMap, null, paramInt);
  }
  
  public void getAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    httpMethodAsync(1, paramString, paramMap, null, paramInt, paramITVKHttpCallback);
  }
  
  public ITVKHttpProcessor.HttpResponse getSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt)
  {
    return httpMethodSync(1, paramString, paramMap, null, paramInt);
  }
  
  public void httpGetCommonSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpProcessor.IWriteCallback paramIWriteCallback)
  {
    httpMethodSync(1, paramString, paramMap, null, paramInt, paramIWriteCallback);
  }
  
  public void httpPostCommonSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpProcessor.IWriteCallback paramIWriteCallback)
  {
    httpMethodSync(2, paramString, paramMap, null, paramInt, paramIWriteCallback);
  }
  
  public void postAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    httpMethodAsync(2, paramString, paramMap, paramArrayOfByte, paramInt, paramITVKHttpCallback);
  }
  
  public ITVKHttpProcessor.HttpResponse postSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt)
  {
    return httpMethodSync(2, paramString, paramMap, null, paramInt);
  }
  
  public void putAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback)
  {
    httpMethodAsync(4, paramString, paramMap, paramArrayOfByte, paramInt, paramITVKHttpCallback);
  }
  
  public void putSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt)
  {
    httpMethodSync(4, paramString, paramMap, null, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpClient
 * JD-Core Version:    0.7.0.1
 */