package com.tencent.tgpa.vendorpd.a;

import org.json.JSONException;
import org.json.JSONObject;

class a$c
{
  public int a;
  public String b;
  public long c;
  public int d;
  public String e;
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("index")) {
      return false;
    }
    if (!paramJSONObject.has("action")) {
      return false;
    }
    if (!paramJSONObject.has("offset")) {
      return false;
    }
    if (!paramJSONObject.has("size")) {
      return false;
    }
    if (!paramJSONObject.has("content")) {
      return false;
    }
    try
    {
      this.a = paramJSONObject.getInt("index");
      this.b = paramJSONObject.getString("action");
      this.c = paramJSONObject.getLong("offset");
      this.d = paramJSONObject.getInt("size");
      this.e = paramJSONObject.getString("content");
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.a.c
 * JD-Core Version:    0.7.0.1
 */