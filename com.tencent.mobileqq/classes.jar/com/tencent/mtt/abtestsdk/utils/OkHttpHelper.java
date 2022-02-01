package com.tencent.mtt.abtestsdk.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import org.json.JSONObject;

public class OkHttpHelper
{
  private static final int DEFAULT_TIMEOUT_SECOND = 3;
  private static volatile OkHttpHelper sInstance;
  private OkHttpClient mClient = new OkHttpClient();
  
  public static OkHttpHelper getsInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new OkHttpHelper();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public OkHttpClient getOkHttpClient()
  {
    if (this.mClient == null)
    {
      ABTestLog.warn("mClient is null and reset init mClient", new Object[0]);
      this.mClient = new OkHttpClient();
    }
    return this.mClient;
  }
  
  public void postRequestWithFormBody(String paramString, Map<String, String> paramMap, int paramInt, Callback paramCallback)
  {
    if ((paramMap != null) && (!paramMap.isEmpty())) {}
    for (;;)
    {
      try
      {
        FormBody.Builder localBuilder = new FormBody.Builder();
        paramMap = paramMap.entrySet().iterator();
        if (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localBuilder.add((String)localEntry.getKey(), (String)localEntry.getValue());
          continue;
        }
        paramMap = localBuilder.build();
        paramString = new Request.Builder().url(paramString).post(paramMap).build();
        if (this.mClient != null) {
          break label233;
        }
        ABTestLog.warn("mClient is null and reset init mClient", new Object[0]);
        this.mClient = new OkHttpClient();
      }
      catch (Exception paramString)
      {
        long l;
        ABTestLog.error(paramString.getMessage(), new Object[0]);
        return;
      }
      paramMap = this.mClient.newBuilder();
      l = paramInt;
      paramMap.connectTimeout(l, TimeUnit.SECONDS).readTimeout(l, TimeUnit.SECONDS).writeTimeout(l, TimeUnit.SECONDS).build().newCall(paramString).enqueue(paramCallback);
      return;
      ABTestLog.warn("post request body is null, please check it!", new Object[0]);
      paramCallback.onFailure(null, new IOException("body params is null"));
      return;
      label233:
      if (paramInt <= 0) {
        paramInt = 3;
      }
    }
  }
  
  public void postRequestWithJSONBody(String paramString, JSONObject paramJSONObject, int paramInt, Callback paramCallback)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = FormBody.create(MediaType.parse("application/json; charset=utf-8"), paramJSONObject.toString());
        paramString = new Request.Builder().url(paramString).post(paramJSONObject).build();
        if (this.mClient != null) {
          break label127;
        }
        ABTestLog.warn("mClient is null and reset init mClient", new Object[0]);
        this.mClient = new OkHttpClient();
      }
      catch (Exception paramString)
      {
        long l;
        ABTestLog.error(paramString.getMessage(), new Object[0]);
        return;
      }
      paramJSONObject = this.mClient.newBuilder();
      l = paramInt;
      paramJSONObject.connectTimeout(l, TimeUnit.SECONDS).readTimeout(l, TimeUnit.SECONDS).writeTimeout(l, TimeUnit.SECONDS).build().newCall(paramString).enqueue(paramCallback);
      return;
      label127:
      if (paramInt <= 0) {
        paramInt = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.OkHttpHelper
 * JD-Core Version:    0.7.0.1
 */