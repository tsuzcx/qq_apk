package com.tencent.qqlive.module.videoreport.storage.util;

import com.google.gson.Gson;
import com.tencent.qqlive.module.videoreport.Log;

public class GsonObjectCoder
  implements Coder
{
  private static final String TAG = "GsonObjectCoder";
  private Gson mGson;
  
  public GsonObjectCoder()
  {
    this(GsonHelper.build());
  }
  
  public GsonObjectCoder(Gson paramGson)
  {
    this.mGson = paramGson;
  }
  
  public <T> T decode(String paramString, Class<T> paramClass)
  {
    try
    {
      paramString = this.mGson.fromJson(paramString, paramClass);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramClass = new StringBuilder();
      paramClass.append("decode failure, error: ");
      paramClass.append(paramString.getLocalizedMessage());
      Log.e("GsonObjectCoder", paramClass.toString());
    }
    return null;
  }
  
  public String encode(Object paramObject)
  {
    try
    {
      paramObject = this.mGson.toJson(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("encode failure, error: ");
      localStringBuilder.append(paramObject.getLocalizedMessage());
      Log.e("GsonObjectCoder", localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.util.GsonObjectCoder
 * JD-Core Version:    0.7.0.1
 */