package com.tencent.stat.common;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfo
{
  public static final int NEW_USER = 0;
  public static final int OLD_USER = 1;
  public static final String TAG_ANDROID_ID = "aid";
  public static final String TAG_FLAG = "__MTA_DEVICE_INFO__";
  public static final String TAG_IMEI = "ui";
  public static final String TAG_MAC = "mc";
  public static final String TAG_MID = "mid";
  public static final String TAG_TIMESTAMPS = "ts";
  public static final String TAG_VERSION = "ver";
  public static final int UPGRADE_USER = 2;
  private String a = null;
  private String b = null;
  private String c = null;
  private String d = "0";
  private int e;
  private int f = 0;
  private long g = 0L;
  
  public DeviceInfo() {}
  
  public DeviceInfo(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.e = paramInt;
  }
  
  JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Util.jsonPut(localJSONObject, "ui", this.a);
      Util.jsonPut(localJSONObject, "mc", this.b);
      Util.jsonPut(localJSONObject, "mid", this.d);
      Util.jsonPut(localJSONObject, "aid", this.c);
      localJSONObject.put("ts", this.g);
      localJSONObject.put("ver", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public String getImei()
  {
    return this.a;
  }
  
  public String getMac()
  {
    return this.b;
  }
  
  public String getMid()
  {
    return this.d;
  }
  
  public int getUserType()
  {
    return this.e;
  }
  
  public void setUserType(int paramInt)
  {
    this.e = paramInt;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.stat.common.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */