package com.tencent.wxop.stat.common;

import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private String a = null;
  private String b = null;
  private String c = null;
  private String d = "0";
  private int e;
  private int f = 0;
  private long g = 0L;
  
  public a() {}
  
  public a(String paramString1, String paramString2, int paramInt)
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
      r.a(localJSONObject, "ui", this.a);
      r.a(localJSONObject, "mc", this.b);
      r.a(localJSONObject, "mid", this.d);
      r.a(localJSONObject, "aid", this.c);
      localJSONObject.put("ts", this.g);
      localJSONObject.put("ver", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.a
 * JD-Core Version:    0.7.0.1
 */